/**
 * 详情对话框
 */
var BusinessDailyReportInfoDlg = {
    data: {
        user: "",
        firstdate: "",
        time: "",
        lastdate: "",
        changes: "",
        other: ""
    }
};

layui.use(['form', 'admin', 'ax', 'table'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var table = layui.table;

    document.getElementById('xh').value = Feng.getUrlParam('xh');
    document.getElementById('beizhu').style.display = "none";

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/businessDailyReport/addItem2?xh="+Feng.getUrlParam('xh'), function (data) {
            Feng.success("更新成功！");

            //传给上个页面，刷新table用
            setTimeout(function () {
                admin.putTempData('formOk', true);

                /*var layId = $(this).attr('lay-id');
                admin.refresh(layId);*/
                //关掉对话框
                parent.layer.closeAll();
            }, 500);

        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    //单选框监听
    form.on('radio', function (data) {
        if (data.value != 0) {
            document.getElementById('beizhu').style.display = "";
        } else {
            document.getElementById('beizhu').style.display = "none";
        }
    });

})
;