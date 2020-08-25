layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var BusinessSummaryReport = {
        tableId: "businessSummaryReportTable"
    };

    /**
     * 初始化表格的列
     */
    BusinessSummaryReport.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'xh', sort: true, title: '学号'},
            {field: 'name', sort: true, title: '姓名'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 导出excel按钮
     */
    BusinessSummaryReport.exportExcel = function () {
        var checkRows = table.checkStatus(BusinessSummaryReport.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + BusinessSummaryReport.tableId,
        url: Feng.ctxPath + '/businessSummaryReport/noReportItem?wbg=' + Feng.getUrlParam('wbg'),
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        id: 'wbg',
        cols: BusinessSummaryReport.initColumn()
    });

    // 导出excel
    $('#btnExp').click(function () {
        BusinessSummaryReport.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + BusinessSummaryReport.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'mail') {
            //
        } else if (layEvent === 'sb') {
            func.open({
                title: '管理员上报',
                content: Feng.ctxPath + '/businessDailyReport/adminadd?xh=' + data.xh,
                tableId: BusinessSummaryReport.tableId
            });
        }
    });
});
