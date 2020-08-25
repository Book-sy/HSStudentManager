/**
 * 添加或者修改页面
 */
var BusinessOutApplicationInfoDlg = {
    data: {
        user: "",
        oneTime: "",
        twoTime: "",
        threeTime: "",
        fourTime: "",
        nowstep: "",
        applicationType: "",
        file: ""
    }
};
layui.use(['form', 'admin', 'ax', 'laydate', 'upload'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var laydate = layui.laydate;
    var admin = layui.admin;
    var upload = layui.upload;

    laydate.render({
        elem: '#cfsj'
        ,type: 'datetime'
    });
    laydate.render({
        elem: '#ddsj'
        ,type: 'datetime'
    });


    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var msg= data.field.cfsj+' 出发离开 '+data.field.cfdd+' ，将于 '+data.field.ddsj+' 抵达 '+data.field.dddd+' 目前身体状况'+data.field.stzk;
        layer.open({
            type: 2,
            title: false,
            closeBtn: 0, //不显示关闭按钮
            shade: [0],
            area: ['1px', '1px'],
            offset: 'rb',
            time: 1000,
            anim: 2,
            content: [Feng.ctxPath + '/businessOutApplication/qr?id=' + Feng.getUrlParam("id")+"&msg="+msg, 'no'],
            success: function(layero, index) {
                Feng.success("确认成功！");
                //传给上个页面，刷新table用
                admin.putTempData('formOk', true);
                //关掉对话框
                admin.closeThisDialog();
            }
        });

        return false;
    });

});