layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Information = {
        tableId: "informationTable"
    };

    /**
     * 初始化表格的列
     */
    Information.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'createUser', sort: true, title: '发送用户'},
            {field: 'text', sort: true, title: '内容'},
            {field: 'toUser', sort: true, title: '接收人'},
            {field: 'reades', sort: true, title: '已读'},
            {field: 'createTime', sort: true, title: '记录时间'},
            {field: 'readTime', sort: true, title: '已读时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Information.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Information.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Information.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/information/add',
            tableId: Information.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Information.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/information/edit?id=' + data.id,
            tableId: Information.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Information.exportExcel = function () {
        var checkRows = table.checkStatus(Information.tableId);
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
    Information.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/information/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Information.tableId);
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
        elem: '#' + Information.tableId,
        url: Feng.ctxPath + '/information/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Information.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Information.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Information.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Information.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Information.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Information.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Information.onDeleteItem(data);
        }
    });
});
