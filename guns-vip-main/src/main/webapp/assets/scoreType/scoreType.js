layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var ScoreType = {
        tableId: "scoreTypeTable"
    };

    /**
     * 初始化表格的列
     */
    ScoreType.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide:true, title: ''},
            {field: 'name', sort: true, title: '学期名称'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    ScoreType.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(ScoreType.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    ScoreType.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/scoreType/add',
            tableId: ScoreType.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    ScoreType.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/scoreType/edit?id=' + data.id,
            tableId: ScoreType.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    ScoreType.exportExcel = function () {
        var checkRows = table.checkStatus(ScoreType.tableId);
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
    ScoreType.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/scoreType/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(ScoreType.tableId);
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
        elem: '#' + ScoreType.tableId,
        url: Feng.ctxPath + '/scoreType/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: ScoreType.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        ScoreType.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        ScoreType.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        ScoreType.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + ScoreType.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            ScoreType.openEditDlg(data);
        } else if (layEvent === 'delete') {
            ScoreType.onDeleteItem(data);
        }
    });
});
