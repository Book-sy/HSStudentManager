/**
 * 详情对话框
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

layui.use(['form', 'admin','laydate', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;

    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/businessOutApplication/detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    form.val('businessOutApplicationForm', result.data);

    //日期时间选择器
    laydate.render({
        elem: '#oneTime'
        ,type: 'datetime'
    });
    laydate.render({
        elem: '#twoTime'
        ,type: 'datetime'
    });
    laydate.render({
        elem: '#threeTime'
        ,type: 'datetime'
    });
    laydate.render({
        elem: '#fourTime'
        ,type: 'datetime'
    });

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/businessOutApplication/editItem", function (data) {
            Feng.success("更新成功！");

            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);

            //关掉对话框
            admin.closeThisDialog();

        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

});