layui.use(['layer', 'carousel','table','admin', 'ax', 'func'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var carousel = layui.carousel;
    var device = layui.device;
    var func = layui.func;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;

    var data = new Date();
    document.getElementById('detaa').innerHTML = data.getFullYear()+'-'+(data.getMonth()+1)+'-'+data.getDate()+'日 每日一报<span class="layui-badge layui-bg-black pull-right">日</span>';

    // 渲染轮播
    carousel.render({
        elem: '.layui-carousel',
        width: '100%',
        height: '60px',
        arrow: 'none',
        autoplay: true,
        trigger: device.ios || device.android ? 'click' : 'hover',
        anim: 'fade'
    });

    $('#bao').click(function () {
        func.open({
            title: '每日一报',
            content: Feng.ctxPath + '/businessDailyReport/bao'
        });
    });

    $('#application').click(function () {
        func.open({
            title: '外出申请',
            content: Feng.ctxPath + '/businessOutApplication/app',
            tableId: 'bt',
            area: 'auto'
        });
    });

    var Index = {
        tableId: "Index"
    };

    var bz = {
        tableId: "bz"
    };

    Index.initColumn = function () {
        return [[
            {field: 'id', hide: true, title: ''},
            {field: 'user', sort: true, hide: true, title: '用户'},
            {field: 'oneTime', sort: true, title: '第一阶段'},
            {field: 'twoTime', sort: true, title: '第二阶段'},
            {field: 'threeTime', sort: true, title: '第三阶段'},
            {field: 'fourTime', sort: true, title: '第四阶段'},
            {field: 'applicationType', align: 'center', sort: true, title: '申请类型', templet: '#type'},
            {field: 'file', align: 'center', sort: true, title: '文件', templet: '#file'},
            {field: 'nowstep', align: 'center', sort: true, title: '申报进度', templet: '#jindu',width: 160},
        ]];
    };

    bz.initColumn = function () {
        return [[
            {field: 'id', hide: true, title: ''},
            {field: 'user', sort: true, title: '姓名'},
            {field: 'oneTime', sort: true, title: '第一阶段'},
            {field: 'twoTime', sort: true, title: '第二阶段'},
            {field: 'threeTime', sort: true, title: '第三阶段'},
            {field: 'fourTime', sort: true, title: '第四阶段'},
            {field: 'applicationType', align: 'center', sort: true, title: '申请类型', templet: '#type'},
            {field: 'file', align: 'center', sort: true, title: '文件', templet: '#file'},
            {field: 'nowstep', align: 'center', sort: true, title: '申报进度', templet: '#bzjd'},
        ]];
    };

    // 渲染表格
    table.render({
        elem: '#Index',
        id: 'bt',
        url: Feng.ctxPath + '/businessOutApplication/listUser',
        page: true,
        cellMinWidth: 100,
        cols: Index.initColumn()
    });

    table.render({
        elem: '#bz',
        id: 'bz',
        url: Feng.ctxPath + '/businessOutApplication/bzlist',
        page: true,
        cellMinWidth: 100,
        cols: bz.initColumn()
    });

    // 工具条点击事件
    table.on('tool(Index)', function (obj) {

        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'download') {
            layer.open({
                type: 2,
                title: false,
                closeBtn: 0, //不显示关闭按钮
                shade: [0],
                area: ['1px', '1px'],
                offset: 'rb',
                time: 1000,
                anim: 2,
                content: [Feng.ctxPath + '/businessOutApplication/export?id=' + data.id, 'no']
            });
        } else if (layEvent === 'qr') {
            func.open({
                title: '修改',
                content: Feng.ctxPath + '/businessOutApplication/sure?id='+data.id,
                tableId: 'bt'
            });
            /*layer.open({
                type: 2,
                title: false,
                closeBtn: 0, //不显示关闭按钮
                shade: [0],
                area: ['1px', '1px'],
                offset: 'rb',
                time: 1000,
                anim: 2,
                content: [Feng.ctxPath + '/businessOutApplication/qr?id=' + data.id, 'no'],
                success: function(layero, index){
                    table.reload('bt');
                }
            });*/
        } else if (layEvent === 'qx') {
            layer.open({
                type: 2,
                title: false,
                closeBtn: 0, //不显示关闭按钮
                shade: [0],
                area: ['1px', '1px'],
                offset: 'rb',
                time: 1000,
                anim: 2,
                content: [Feng.ctxPath + '/businessOutApplication/qx?id=' + data.id, 'no'],
                success: function(layero, index){
                    table.reload('bt');
                }
            });
        } else if (layEvent === 'xg') {
            func.open({
                title: '修改',
                content: Feng.ctxPath + '/businessOutApplication/eapp?id=' + data.id,
                tableId: 'bt'
            });
        }
    });
});