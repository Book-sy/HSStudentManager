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
            {field: 'id', hide: true, title: ''},
            {field: 'user', sort: true, title: '用户名'},
            {field: 'classes', sort: true, title: '班级'},
            {field: 'firstdate', sort: true, title: '上报时间'},
            {field: 'time', sort: true, title: '修改次数'},
            {field: 'lastdate', sort: true, title: '最后修改'},
            {field: 'changes', sort: true, title: '是否变化', templet: '#table-gender'},
            {field: 'other', sort: true, title: '备注'}
        ]];
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

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + BusinessDailyReport.tableId,
        url: Feng.ctxPath + '/businessSummaryReport/changesItem?changes='+Feng.getUrlParam('changes'),
        height: "full-158",
        cellMinWidth: 100,
        cols: BusinessDailyReport.initColumn()
    });

    // 导出excel
    $('#btnExp').click(function () {
        BusinessDailyReport.exportExcel();
    });
});
