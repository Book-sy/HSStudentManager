layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var BusinessDailyReport = {
        tableId: "businessDailyReportTable"
    };

    /**
     * 初始化表格的列
     */
    BusinessDailyReport.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'user', sort: true, title: '用户名'},
            {field: 'xh', sort: true, title: '学号'},
            {field: 'classes', sort: true, title: '班级'},
            {field: 'firstdate', sort: true, title: '上报时间'},
            {field: 'time', sort: true, title: '修改次数'},
            {field: 'lastdate', sort: true, title: '最后修改'},
            {field: 'changes', sort: true, title: '是否变化', templet: '#table-gender'},
            {field: 'other', sort: true, title: '备注'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    BusinessDailyReport.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(BusinessDailyReport.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    BusinessDailyReport.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/businessDailyReport/add',
            tableId: BusinessDailyReport.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    BusinessDailyReport.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/businessDailyReport/edit?id=' + data.id,
            tableId: BusinessDailyReport.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    BusinessDailyReport.exportExcel = function () {
        var checkRows = table.checkStatus(BusinessDailyReport.tableId);
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
    BusinessDailyReport.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/businessDailyReport/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(BusinessDailyReport.tableId);
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
        elem: '#' + BusinessDailyReport.tableId,
        url: Feng.ctxPath + '/businessDailyReport/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: BusinessDailyReport.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        BusinessDailyReport.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        BusinessDailyReport.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        BusinessDailyReport.exportExcel();
    });

    // 工具条点击事件1
    table.on('tool(' + BusinessDailyReport.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            BusinessDailyReport.openEditDlg(data);
        } else if (layEvent === 'delete') {
            BusinessDailyReport.onDeleteItem(data);
        }
    });
});
