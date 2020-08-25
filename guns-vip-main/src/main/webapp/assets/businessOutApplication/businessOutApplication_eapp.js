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

layui.use(['form', 'admin', 'ax', 'laydate', 'upload'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var laydate = layui.laydate;
    var admin = layui.admin;
    var upload = layui.upload;

    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/businessOutApplication/detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    form.val('businessOutApplicationForm', result.data);

    //文件接口
    upload.render({
        elem: '#filebtn'
        ,url: '/businessOutApplication/file'
        ,accept: 'file' //普通文件
        ,before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
            obj.preview(function(index, file, result){
                $('#filebtn').text(file.name);
            });
        }
        ,done: function(res){
            layer.msg('上传成功');
            document.getElementById("file").value = res.data;
        }
        ,field: 'file'
    });
    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        data.field.file = document.getElementById("file").value;
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