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

    //文件接口
    upload.render({
        elem: '#filebtn'
        ,url: '/businessOutApplication/file' //改成您自己的上传接口
        ,accept: 'file' //普通文件
        ,done: function(res){
            layer.msg('上传成功');
            document.getElementById("file").value = res.data;
        }
        ,field: 'file'
    });
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
        data.field.file = document.getElementById("file").value;
        var ajax = new $ax(Feng.ctxPath + "/businessOutApplication/addItem", function (data) {
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