/**
 * 添加或者修改页面
 */
var TemperatureInfoDlg = {
    data: {
        user: "",
        day: "",
        first: "",
        firstTime: "",
        firstJ: "",
        firstW: "",
        second: "",
        secondTime: "",
        secondJ: "",
        secondW: "",
        third: "",
        thirdTime: "",
        thirdJ: "",
        thirdW: ""
    }
};

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/temperature/addItem", function (data) {
            Feng.success("添加成功！");

            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);

            //关掉对话框
            admin.closeThisDialog();

        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

});