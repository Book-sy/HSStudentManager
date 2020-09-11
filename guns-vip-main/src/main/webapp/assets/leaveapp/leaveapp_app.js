/**
 * 添加或者修改页面
 */
var LeaveappInfoDlg = {
    data: {
        userId: "",
        xiaoqu: "",
        sushehao: "",
        xueyuan: "",
        reason: "",
        startTime: "",
        endTime: "",
        shenfenzheng: "",
        chuxingguiji: "",
        jinjilianxiren: "",
        guanxi: "",
        phone: "",
        address: "",
        xueyuanyijian: "",
        time: "",
        banzhangyijian: "",
        banzhangTime: "",
        banzhurenyijian: "",
        banzhurenTime: "",
        fudaoyuanyijian: "",
        fudaoyuanTime: ""
    }
};

/** 地图相关代码 */
var map = new AMap.Map('container', {
    resizeEnable: true, //是否监控地图容器尺寸变化
    zoom: 16, //初始化地图层级
    center: [ 116.38223,39.988922 ] //初始化地图中心点
});

var markers = [];
var positions = [];

//绑定鼠标双击事件
map.on('dblclick', (e) => {
    if(markers.length >= 5){
        alert("地点设置超过上限");
        return;
    }
    add(e);
    refuse();
});

function chehui() {
    if(positions.length == 0)
        return;
    positions.pop();
    refuse();
    refuseGJ();
}

function qingkong() {
    positions = [];
    refuse();
    document.getElementById("chuxinggj").value = '';
}

function refuseGJ() {
    var gj = document.getElementById("chuxinggj").value.split(' ==> ');
    var text = '';
    for(var i=1;i<gj.length-1;i++){
        text += ' ==> ' + gj[i];
    }
    document.getElementById("chuxinggj").value = text;
}

function add(e) {
    position = [e.lnglat.getLng(),e.lnglat.getLat()];
    positions.push(position);
    layui.use('ax', function () {
        var $ax = layui.ax;
        new $ax("https://restapi.amap.com/v3/geocode/regeo?key=caa408034c27b0552255ab633c15858d&location=" + e.lnglat.getLng() + "," + e.lnglat.getLat() + "+&poitype=&radius=10&extensions=all&batch=false&roadlevel=0", function (data) {
            var cxgj = document.getElementById("chuxinggj");
            cxgj.value = cxgj.value + (' ==> ' + data.regeocode.formatted_address + '\n');
        }, function (data) {
            Feng.error("地点信息查询失败" + data.responseJSON.message)
        }).start();
    })
}

function refuse(){
    map.remove(markers);
    markers = [];
    for(var i=0;i<positions.length;i++){
        marker = new AMap.Marker({
            map: map,
            icon: '//a.amap.com/jsapi_demos/static/demo-center/icons/poi-marker-' + (i + 1) + '.png',
            position: positions[i],
            offset: new AMap.Pixel(0,0),
            anchor: 'bottom-center'
        });
        markers.push(marker);
    }
}

var func;
var signImga = function (res) {
    document.getElementById("sign").value = res;
};
/** layui 相关代码 */
layui.use(['form', 'admin', 'ax', 'laydate', 'upload'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var upload = layui.upload;

    var f;
    upload.render({
        elem: '#filebtn'
        ,url: '/leaveapp/fileUp'
        ,accept: 'file'
        ,before: function(obj){
            layer.load();
            obj.preview(function(index, file, result){
                $('#filebtn').text(file.name);
            });
        }
        ,done: function(res){
            console.log(res.fileId);
            f = res.fileId;
            layer.msg('上传成功');
            layer.closeAll('loading');
        }
        ,error: function(index, upload){
            layer.closeAll('loading'); //关闭loading
        }
        ,field: 'upfile'
    });

    laydate.render({
        elem: '#startTime'
        ,type: 'datetime'
        ,trigger: 'click'
    });

    laydate.render({
        elem: '#endTime'
        ,type: 'datetime'
        ,trigger: 'click'
    });

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {

        func = function () {
            var ajax = new $ax(Feng.ctxPath + "/leaveapp/appItem", function (data) {
                Feng.success("添加成功！");

                //传给上个页面，刷新table用
                admin.putTempData('formOk', true);

                //关掉对话框
                admin.closeThisDialog();

            }, function (data) {
                Feng.error("添加失败！" + data.responseJSON.message)
            });
            data.field.chuxingguiji = positions.join('|');
            data.field.sign = document.getElementById("sign").value;
            data.field.file = f;
            ajax.set(data.field);
            ajax.start();
        }

        layer.open({
            type: 2,
            area: ['800px', '600px'],
            fixed: false, //不固定
            maxmin: true,
            content: Feng.ctxPath+'/leaveapp/sign'
        });

        return false;
    });

});