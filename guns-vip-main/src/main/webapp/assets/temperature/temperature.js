layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Temperature = {
        tableId: "temperatureTable"
    };

    /**
     * 初始化表格的列
     */
    Temperature.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'user', sort: true, title: '用户id'},
            {field: 'day', sort: true, title: '日期'},
            {field: 'first', sort: true, title: '第一次温度'},
            {field: 'firstTime', sort: true, title: '第一次时间'},
            {field: 'firstJ', sort: true, title: '第一次经度'},
            {field: 'firstW', sort: true, title: '第一次纬度'},
            {field: 'second', sort: true, title: '第二次温度'},
            {field: 'secondTime', sort: true, title: '第二次时间'},
            {field: 'secondJ', sort: true, title: '第二次经度'},
            {field: 'secondW', sort: true, title: '第二次纬度'},
            {field: 'third', sort: true, title: '第三次温度'},
            {field: 'thirdTime', sort: true, title: '第三次时间'},
            {field: 'thirdJ', sort: true, title: '第三次经度'},
            {field: 'thirdW', sort: true, title: '第三次纬度'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Temperature.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Temperature.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Temperature.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/temperature/add',
            tableId: Temperature.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Temperature.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/temperature/edit?id=' + data.id,
            tableId: Temperature.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Temperature.exportExcel = function () {
        var checkRows = table.checkStatus(Temperature.tableId);
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
    Temperature.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/temperature/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Temperature.tableId);
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
        elem: '#' + Temperature.tableId,
        url: Feng.ctxPath + '/temperature/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Temperature.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Temperature.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Temperature.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Temperature.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Temperature.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Temperature.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Temperature.onDeleteItem(data);
        }
    });
});
