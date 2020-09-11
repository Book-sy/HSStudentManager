layui.use(['layer', 'carousel', 'table', 'admin', 'ax', 'func', 'laytpl', 'laydate', 'index'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var carousel = layui.carousel;
    var device = layui.device;
    var func = layui.func;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var laytpl = layui.laytpl;
    var index = layui.index;

    laytpl(sq.innerHTML).render({
        "title": "请假申请",
        "danwei": "单",
        "button": "开始申请",
        "buttonid": "qjsq",
        "zj": "总计递交单数：",
        "sl": "200 ",
        "class": "layui-btn layui-btn"
    }, function (html) {
        document.getElementById('sqb').innerHTML = html;
    });

    laytpl(sq.innerHTML).render({
        "title": "测试中...",
        "danwei": "单",
        "button": "测试版可用",
        "buttonid": "sqd",
        "zj": "测试数：",
        "sl": "0+",
        "class": "layui-btn layui-btn-disabled"
    }, function (html) {
        document.getElementById('sqb2').innerHTML = html;
    });

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

    $('#qjsq').click(function () {
        func.open({
            title: '请假申请',
            content: Feng.ctxPath + '/leaveapp/app',
            tableId: 'bt',
            area: 'auto'
        });
    });

    var Index = {
        tableId: "Index"
    };

    Index.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'xiaoqu', title: '校区'},
            {field: 'sushehao', title: '宿舍号'},
            {field: 'xueyuan', title: '学院'},
            {field: 'reason', title: '原因'},
            {field: 'startTime', title: '开始时间'},
            {field: 'endTime', title: '结束时间'},
            {field: 'shenfenzheng', title: '身份证号'},
            {field: 'chuxingguiji', title: '出行轨迹', align: 'center', templet: '#gj'},
            {field: 'jinjilianxiren', title: '紧急联系人'},
            {field: 'guanxi', title: '关系'},
            {field: 'phone', title: '紧急电话'},
            {field: 'address', title: '出校居住地'},
            {field: 'appTime', title: '申请时间'},
            {field: 'xueyuanyijian', title: '学院意见', templet: '#xueyuanyijian'},
            /*{field: 'banzhangyijian', title: '班长意见', templet: '#banzhangyijian'},
            {field: 'banzhurenyijian', title: '班主任意见', templet: '#banzhurenyijian'},*/
            {field: 'fudaoyuanyijian', title: '辅导员意见', templet: '#fudaoyuanyijian'},
        ]];
    };

    // 渲染表格
    table.render({
        elem: '#Index',
        id: 'bt',
        url: Feng.ctxPath + '/leaveapp/uslist',
        method: 'POST',
        where: {
          sf: 'stu'
        },
        page: true,
        cellMinWidth: 100,
        cols: Index.initColumn()
    });

    // 工具条点击事件
    table.on('tool(Index)', function (obj) {

        var datas = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'gj') {
            var url = 'https://restapi.amap.com/v3/staticmap?key=caa408034c27b0552255ab633c15858d&size=800*800&labels=';
            var ajax = new $ax("https://restapi.amap.com/v3/geocode/regeo?key=caa408034c27b0552255ab633c15858d&radius=0&extensions=all&batch=true&roadlevel=0&location=" + datas.chuxingguiji, function (data) {
                var d = datas.chuxingguiji.split('|');
                for (var i = 0; i < data.regeocodes.length; i++) {
                    if (i != 0)
                        url += '|';
                    var loname = (i + 1) + '、' + ((data.regeocodes[i].aois.length == 0) ? (data.regeocodes[i].addressComponent.streetNumber.street + data.regeocodes[i].addressComponent.streetNumber.number) : data.regeocodes[i].aois[0].name);
                    if(loname.length>15)
                        loname = loname.substring(0,2)+loname.substring(loname.length-13,loname.length)
                    url += loname + ',0,1,20,0xFFFFFF,0x2075EB:' + d[i];
                }
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 0,
                    area: ['800px', '800px'],
                    skin: 'layui-layer-nobg',
                    shadeClose: true,
                    content: " <span style='text-align: center;display:block'><img src='" + url + "'> </span> "
                });
            }, function (data) {
                Feng.error("地点信息查询失败" + data.responseJSON.message)
            });
            ajax.type = 'GET';
            ajax.start();
        }
    });
});