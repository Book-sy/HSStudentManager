var refuse = function(){};
layui.use(['laytpl','ax'], function() {
    var laytpl = layui.laytpl;
    var $ax = layui.ax;

    refuse = function () {
        new $ax(Feng.ctxPath + "/information/haveifm", function (data) {
            if(data) {
                laytpl(demo.innerHTML, view = document.getElementById('xx')).render({}, function (html) {
                    view.innerHTML = html;
                });
            }
        }, function (data) {
            Feng.error("信息查询失败！" + data.responseJSON.message)
        }).start();
    }
    refuse();
});