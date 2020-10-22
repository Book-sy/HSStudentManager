function openmes(id){};
layui.use(['element', 'laytpl', 'ax', 'func'], function () {
    var $ = layui.jquery;
    var element = layui.element;
    var laytpl = layui.laytpl;
    var $ax = layui.ax;
    var func = layui.func;

    // 加载更多按钮点击事件
    /*$('#btn-more1').click(function () {
        var $that = $(this);
        var str = $that.prev()[0].outerHTML;
        for (var i = 0; i < 5; i++) {
            $that.before(str);
        }
    });*/

    openmes = function(id){
        new $ax(Feng.ctxPath + '/information/look?id='+id, function (data) {
            layer.alert(data.data.text, {
                skin: 'layui-layer-lan'
                ,closeBtn: 0
                ,anim: 4
            });
            refuseInform();
            parent.refuse();
        }, function (data) {
            Feng.error("信息打开失败！" + data.responseJSON.message)
        }).start();
    }

    // 清空消息点击事件
    $('.message-btn-clear').click(function () {
        $(this).css('display', 'none');
        $(this).prev().find('.message-list-item').remove();
        $(this).prev().find('.message-btn-more').remove();
        $(this).prev().find('.message-list-empty').css('display', 'block');
    });

    function refuseInform() {
        new $ax(Feng.ctxPath + "/information/uslist", function (data) {
            var getTpl = demo.innerHTML
                ,view = document.getElementById('view');
            laytpl(getTpl).render(data, function(html){
                view.innerHTML = html;
            });
        }, function (data) {
            Feng.error("查询失败！" + data.responseJSON.message)
        }).start();
    }
    refuseInform();

});