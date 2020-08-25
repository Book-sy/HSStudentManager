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

layui.use(['form', 'admin', 'ax', 'laydate', 'upload', 'table'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var laydate = layui.laydate;
    var admin = layui.admin;
    var upload = layui.upload;
    var table = layui.table;

    var $ = layui.$, active = {
        parseTable: function(){
            table.init('parse-table-demo', { //转化静态表格
                //height: 'full-500'
            });
        }
    };
    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
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
        var ajax = new $ax(Feng.ctxPath + "/businessOutApplication/appItem", function (data) {
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