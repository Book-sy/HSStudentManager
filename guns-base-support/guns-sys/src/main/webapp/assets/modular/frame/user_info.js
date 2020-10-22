layui.use(['jquery', 'index', 'table','form', 'upload', 'element', 'ax', 'laydate', 'citypicker'], function () {
    var $ = layui.jquery;
    var form = layui.form;
    var upload = layui.upload;
    var element = layui.element;
    var $ax = layui.ax;
    var laydate = layui.laydate;
    var cityPicker = layui.citypicker;
    var table = layui.table;

    //渲染时间选择框
    laydate.render({
        elem: '#birthday'
    });

    //获取用户详情
    var ajax = new $ax(Feng.ctxPath + "/system/currentUserInfo");
    var result = ajax.start();

    //用这个方法必须用在class有layui-form的元素上
    form.val('userInfoForm', result.data);
    form.val('otherUserInfoForm', result.data);
    form.val('familyUserInfoForm', result.data);

    //表单提交事件
    form.on('submit()', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/mgr/edit", function (data) {
            Feng.success("修改成功!");
        }, function (data) {
            Feng.error("修改失败!" + data.responseJSON.message + "!");
        });
        ajax.set(data.field);
        ajax.start();
    });


    new cityPicker("#natives", {
        provincename: "provinceId",
        cityname: "cityId",
        districtname: "districtId",
        level: 'cityId',
    });

    new cityPicker("#origin", {
        provincename: "provinceId",
        cityname: "cityId",
        districtname: "districtId",
        level: 'cityId',
    });

    upload.render({
        elem: '#imgHead'
        , url: Feng.ctxPath + '/system/upload'
        , before: function (obj) {
            obj.preview(function (index, file, result) {
                $('#avatarPreview').attr('src', result);
            });
        }
        , done: function (res) {
            var ajax = new $ax(Feng.ctxPath + "/system/updateAvatar", function (data) {
                Feng.success(res.message);
            }, function (data) {
                Feng.error("修改失败!" + data.responseJSON.message + "!");
            });
            ajax.set("fileId", res.data.fileId);
            ajax.start();
        }
        , error: function () {
            Feng.error("上传头像失败！");
        }
    });
});