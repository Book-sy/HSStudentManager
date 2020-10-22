layui.use(['table', 'admin', 'ax', 'func', 'laytpl'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;
    var laytpl = layui.laytpl;

    /**
     * 管理
     */
    var Score = {
        tableId: "scoreTable"
    };

    /**
     * 初始化表格的列
     */
    Score.initColumn = function () {
        return [[
            {field: 'id', hide: true, title: ''},
            {field: 'eveNum', hide: true, title: ''},
            {field: 'user', title: '学号'},
            {field: 'name', title: '姓名'},
            {field: 'classes', title: '班级'},
            {field: 'type', title: '学期类型'},
            {field: 'score', title: '平均学分绩点'},
            {field: 'ranking', title: '专业内排名'},
            {align: 'center', toolbar: '#tableBar', title: '操作', width: '200',fixed:'right'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Score.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Score.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Score.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/score/add',
            tableId: Score.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Score.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/score/edit?id=' + data.id,
            tableId: Score.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Score.exportExcel = function () {
        var checkRows = table.checkStatus(Score.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Score.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/score/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Score.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Score.tableId,
        url: Feng.ctxPath + '/score/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Score.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Score.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Score.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Score.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Score.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Score.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Score.onDeleteItem(data);
        } else if (layEvent === 'eve') {
            layer.open({
                type: 2,
                title: '选择字段',
                area: ['1200px', '600px'],
                content: Feng.ctxPath + '/scoreEvaluate/admineve?id='+data.id
            });
        }
    });
});
