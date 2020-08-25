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

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/businessDailyReport/getbao");
    var result = ajax.start();
    if (result.data.changes != 0) {
        document.getElementById('beizhu').style.display = "";
    } else {
        document.getElementById('beizhu').style.display = "none";
    }
    form.val('businessDailyReportForm', result.data);

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var path = (data.field.id!='')?'editItem':'addItem';
        var ajax = new $ax(Feng.ctxPath + "/businessDailyReport/"+path, function (data) {
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