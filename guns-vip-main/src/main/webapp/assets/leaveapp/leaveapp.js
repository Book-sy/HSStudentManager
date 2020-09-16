layui.use(['table', 'admin', 'ax', 'func', 'upload', 'layer', 'form', 'laydate'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;
    var upload = layui.upload;
    var layer = layui.layer;
    var form = layui.form;
    var laydate = layui.laydate;


    //日期范围
    laydate.render({
        elem: '#rq'
        ,range: '~'
    });

    /**
     * 管理
     */
    var Leaveapp = {
        tableId: "leaveappTable"
    };

    /**
     * 初始化表格的列
     */
    Leaveapp.initColumn = function () {
        var newVar = [[
            {field: 'id', hide: true, title: ''},
            {field: 'name', title: '姓名'},
            {field: 'dn', title: '班级'},
            {field: 'xh', title: '学号'},
            {field: 'nature', title: '性质', templet: '#xz'},
            {field: 'myPhone', title: '联系方式'},
            {field: 'xiaoqu', title: '校区'},
            {field: 'sushehao', title: '宿舍号'},
            {field: 'xueyuan', title: '学院'},
            {field: 'reason', title: '原因'},
            {field: 'startTime', title: '开始时间'},
            {field: 'endTime', title: '结束时间'},
            {field: 'shenfenzheng', title: '身份证号'},
            {field: 'chuxingguiji', title: '出行轨迹', align: 'center', templet: '#gj'},
            {field: 'file', title: '证明材料', align: 'center', templet: '#cl'},
            {field: 'jinjilianxiren', title: '紧急联系人'},
            {field: 'guanxi', title: '关系'},
            {field: 'phone', title: '电话号码'},
            {field: 'address', title: '出校居住地'},
            {field: 'appTime', title: '申请时间'},
            {field: 'xueyuanyijian', title: '学院意见', templet: '#xueyuanyijian'},
            {field: 'time', title: '学院审批时间'},
            {field: 'fudaoyuanyijian', title: '辅导员意见', templet: '#fudaoyuanyijian'},
            {field: 'fudaoyuanTime', title: '辅导员审批时间'},
            {field: 'otheryijian', title: '其他意见', templet: '#otheryijian'},
            {field: 'othertime', title: '意见审批时间'},
        ]];
        if (document.getElementById('var').value == 1) {
            newVar[0].unshift(
                {align: 'center', toolbar: '#tableBar', title: '操作', fixed: 'left', width: 150},
                {field: 'fileId', align: 'center', toolbar: '#file', title: '文件', fixed: 'left', width: 150}
            )
        } else {
            newVar[0].unshift(
                {align: 'center', toolbar: '#tableBar', title: '操作', fixed: 'left', width: 150}
            )
        }
        return newVar;
    };

    /**
     * 点击查询按钮
     */
    Leaveapp.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Leaveapp.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Leaveapp.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/leaveapp/add',
            tableId: Leaveapp.tableId
        });
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    Leaveapp.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/leaveapp/edit?id=' + data.id,
            tableId: Leaveapp.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Leaveapp.exportExcel = function () {
        var data = document.getElementById("rq").value;
        if (data == null || data == '') {
            Feng.error("请选择要导出的数据时间范围");
        } else {
            var riqi = data.split(" ~ ")
            window.open(Feng.ctxPath + '/leaveapp/getExcel?starTime=' + riqi[0] + "&endTime=" + riqi[1])
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Leaveapp.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/leaveapp/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Leaveapp.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var id = {};
    var tableResult = table.render({
        elem: '#' + Leaveapp.tableId,
        url: Feng.ctxPath + '/leaveapp/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Leaveapp.initColumn(),
        done: function (res, curr, count) {
            upload.render({
                elem: '.gx'
                , url: Feng.ctxPath + '/leaveapp/fileUpdate'
                , accept: 'file'
                , method: 'post'
                , data: {
                    id: function () {
                        return id.id;
                    }
                }
                , before: function (index, file, result) {
                    id.id = this.item.attr('value');
                    layer.load();
                }
                , done: function (res) {
                    layer.closeAll('loading');
                    layer.msg('上传成功');
                    //table.reload('XXXTable');
                    //tableDoReload();
                    table.reload(Leaveapp.tableId);
                }
                , field: 'upfile'
            });
        }
    });

    //监听复选 ‘wsp’
    form.on('checkbox(wsp)', function(data){
        if(data.elem.checked){
            table.reload(Leaveapp.tableId, {
                where: {
                    sx: 'wsp'
                }
            });
        } else {
            table.reload(Leaveapp.tableId, {
                where: {
                    sx: null
                }
            });
        }
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Leaveapp.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Leaveapp.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Leaveapp.exportExcel();
    });


    // 工具条点击事件
    table.on('tool(' + Leaveapp.tableId + ')', function (obj) {
        var datas = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Leaveapp.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Leaveapp.onDeleteItem(data);
        } else if (layEvent === 'gj') {
            var url = 'https://restapi.amap.com/v3/staticmap?key=caa408034c27b0552255ab633c15858d&size=800*800&labels=';
            var ajax = new $ax("https://restapi.amap.com/v3/geocode/regeo?key=caa408034c27b0552255ab633c15858d&radius=0&extensions=all&batch=true&roadlevel=0&location=" + datas.chuxingguiji, function (data) {
                console.log(data);
                var d = datas.chuxingguiji.split('|');
                for (var i = 0; i < data.regeocodes.length; i++) {
                    if (i != 0)
                        url += '|';
                    var loname = (i + 1) + '、' + ((data.regeocodes[i].aois.length == 0) ? (data.regeocodes[i].addressComponent.streetNumber.street + data.regeocodes[i].addressComponent.streetNumber.number) : data.regeocodes[i].aois[0].name);
                    if (loname.length > 15)
                        loname = loname.substring(0, 2) + loname.substring(loname.length - 13, loname.length)
                    url += loname + ',0,1,20,0xFFFFFF,0x2075EB:' + d[i];
                }
                layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 0,
                    area: ['800px', '800px'],
                    skin: 'layui-layer-nobg',
                    shadeClose: true,
                    content: " <span style='text-align: center;display:block'><img src='" + url + "'> </span> "
                });
            }, function (data) {
                Feng.error("地点信息查询失败" + data.responseJSON.message)
            });
            ajax.type = 'GET';
            ajax.start();
        } else if (layEvent === 'tg') {
            var operation = function () {
                var ajax = new $ax(Feng.ctxPath + "/leaveapp/sp", function (data) {
                    Feng.success("批阅成功!");
                    table.reload(Leaveapp.tableId);
                }, function (data) {
                    Feng.error("批阅失败!" + data.responseJSON.message + "!");
                });
                ajax.set("id", datas.id);
                ajax.set("yj", "通过");
                ajax.start();
            };
            Feng.confirm("确认通过申请?", operation);
        } else if (layEvent === 'bh') {
            var ajax = new $ax(Feng.ctxPath + "/leaveapp/sp", function (data) {
                Feng.success("驳回成功!");
                table.reload(Leaveapp.tableId);
            }, function (data) {
                Feng.error("驳回失败!" + data.responseJSON.message + "!");
            });
            layer.prompt({
                formType: 2,
                value: '原因不清晰...',
                title: '驳回提示 (简单明了)',
            }, function (val, index) {
                ajax.set("yj", val);
                ajax.set("id", datas.id);
                ajax.start();
                layer.close(index);
            });
        } else if (layEvent === 'xz') {
            window.open(Feng.ctxPath + '/leaveapp/file?fileId=' + datas.fileId + "&userId=" + datas.userId + "&leaveId=" + datas.id)
        } else if (layEvent === 'gx') {

        } else if (layEvent === 'cl') {
            window.open(Feng.ctxPath + '/leaveapp/file?fileId=' + datas.file + "&userId=" + datas.userId + "&leaveId=" + datas.id);
        }
    });
});
