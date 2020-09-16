/** layui 相关代码 */
layui.use(['form', 'admin', 'ax', 'laydate', 'layer'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var layer = layui.layer;

    function convertCanvasToImage(canvas) {
        return canvas.toDataURL("image/png");
    };

    function takeScreenshot() {
        html2canvas(document.body, {
            width: document.body.clientWidth,
        }).then(function(canvas) {

            var index = parent.layer.getFrameIndex(window.name);

            var ajax = new $ax(Feng.ctxPath + "/leaveapp/signUp", function (data) {

                parent.signImga(data.fileId);
                parent.func();
                parent.layer.close(index);

            }, function (data) {
                Feng.error("添加失败！" + data.responseJSON.message)
            });
            ajax.set({
                img: convertCanvasToImage(canvas)
            });
            parent.layer.load();
            setTimeout(function () {
                ajax.start();
            })
        });
    };
    $(function() {
        //初始化
        $(document).esign("canvasEdit", "sign_show", "sign_clear", "sign_ok");
        $(document).on('click', '#sign_clear2', takeScreenshot);
    });

});