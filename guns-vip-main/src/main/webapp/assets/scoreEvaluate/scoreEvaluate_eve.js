layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var ScoreEvaluate = {
        tableId: "scoreEvaluateTable"
    };

    /**
     * 初始化表格的列
     */
    ScoreEvaluate.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'scoreId', hide: true,sort: true, title: '分数id'},
            {field: 'evaluate', width:'70%',sort: true, title: '评价',templet: function(d){
                    var temp = d.evaluate.replace(/&amp;/g,"&")
                    .replace(/&lt;/g,"<")
                    .replace(/&gt;/g,">")
                    .replace(/&nbsp;/g," ")
                    .replace(/&#39;/g,"\'")
                    .replace(/&quot;/g,"\"");
                    return temp;
                }},
            {field: 'createUser', sort: true, title: '评价人'},
            {field: 'updataTime', hide: true,sort: true, title: '更新时间'},
            {field: 'createTime', hide: true,sort: true, title: '评价时间'},
        ]];
    };

    /**
     * 点击查询按钮
     */
    ScoreEvaluate.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(ScoreEvaluate.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    ScoreEvaluate.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/scoreEvaluate/add?id='+Feng.getUrlParam('id'),
            tableId: ScoreEvaluate.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    ScoreEvaluate.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/scoreEvaluate/edit?id=' + data.id,
            tableId: ScoreEvaluate.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    ScoreEvaluate.exportExcel = function () {
        var checkRows = table.checkStatus(ScoreEvaluate.tableId);
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
    ScoreEvaluate.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/scoreEvaluate/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(ScoreEvaluate.tableId);
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
        elem: '#' + ScoreEvaluate.tableId,
        url: Feng.ctxPath + '/scoreEvaluate/uslist?id='+Feng.getUrlParam('id'),
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: ScoreEvaluate.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        ScoreEvaluate.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        ScoreEvaluate.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        ScoreEvaluate.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + ScoreEvaluate.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            ScoreEvaluate.openEditDlg(data);
        } else if (layEvent === 'delete') {
            ScoreEvaluate.onDeleteItem(data);
        }
    });
});
