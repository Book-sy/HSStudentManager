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
            {field: 'classes', sort: true, title: '班级'},
            {field: 'mc', sort: true, hide: true, title: 'mc'},
            {field: 'situation', sort: true, title: '已报告 / 总人数'},
            {field: 'change', sort: true, title: '变化人数'},
            {field: 'json', sort: true, hide: true, title: '备注(隐藏)'},
            {align: 'center', width: 340, toolbar: '#tableBar', title: '操作'}
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
        url: Feng.ctxPath + '/businessSummaryReport/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        id: 'businessSummaryReportTable',
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

        if (layEvent === 'edit') {
            func.open({
                title: '未报告名单',
                content: Feng.ctxPath + '/businessSummaryReport/noReport?wbg=' + escape(JSON.parse(data.json).weibaogao),
                tableId: BusinessSummaryReport.tableId
            });
        } else if (layEvent === 'delete') {
            func.open({
                title: '变化名单',
                content: Feng.ctxPath + '/businessSummaryReport/changes?changes=' + escape(JSON.parse(data.json).bianhua)
            });
        } else if (layEvent === 'zan') {
            layer.msg('开心:)', {icon: 6});
        } else if (layEvent === 'bao') {
            layer.open({
                type: 2,
                title: false,
                closeBtn: 0,
                shade: [0],
                area: ['1px', '1px'],
                offset: 'rb',
                time: 10000,
                anim: 2,
                content: [Feng.ctxPath + '/businessDailyReport/yjb?xh=' + escape(JSON.parse(data.json).weibaogao), 'no'],
                success: function (layero, index) {
                    table.reload('businessSummaryReportTable');
                    setTimeout(function () {
                        var layId = $(this).attr('lay-id');
                        admin.refresh(layId);
                    }, 500);
                }
            });
        }
    });
});
