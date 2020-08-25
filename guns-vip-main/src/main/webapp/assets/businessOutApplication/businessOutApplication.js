layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var BusinessOutApplication = {
        tableId: "businessOutApplicationTable"
    };

    /**
     * 初始化表格的列
     */
    BusinessOutApplication.initColumn = function () {
        return [[
            {field: 'id', hide: true, title: ''},
            {field: 'user', sort: true, title: '用户'},
            {field: 'cls', sort: true, title: '班级'},
            {field: 'oneTime', sort: true, title: '第一阶段'},
            {field: 'twoTime', sort: true, title: '第二阶段'},
            {field: 'threeTime', sort: true, title: '第三阶段'},
            {field: 'fourTime', sort: true, title: '第四阶段'},
            {field: 'applicationType', align: 'center', sort: true, title: '申请类型', templet: '#type'},
            {field: 'file', align: 'center', sort: true, title: '文件', templet: '#file',width: 120},
            {field: 'nowstep', align: 'center', sort: true, title: '申报进度', templet: '#jindu',width: 160},
            {align: 'center', toolbar: '#tableBar', title: '操作',width: 120},
            {field: 'beizhu',  title: '备注'},
        ]];
    };

    /**
     * 点击查询按钮
     */
    BusinessOutApplication.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload('bt', {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    BusinessOutApplication.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/businessOutApplication/add',
            tableId: 'bt'
        });
    };

    /**
     * 点击编辑
     *
     * @param data 点击按钮时候的行数据
     */
    BusinessOutApplication.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/businessOutApplication/edit?id=' + data.id,
            tableId: 'bt'
        });
    };

    /**
     * 导出excel按钮
     */
    BusinessOutApplication.exportExcel = function () {
        var checkRows = table.checkStatus('bt');
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    BusinessOutApplication.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/businessOutApplication/delete", function (data) {
                Feng.success("删除成功!");
                table.reload('bt');
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + BusinessOutApplication.tableId,
        id: 'bt',
        url: Feng.ctxPath + '/businessOutApplication/list',
        page: true,
        cellMinWidth: 100,
        cols: BusinessOutApplication.initColumn(),
        autoSort: true,
        initSort: {
            field: 'id'
            ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
        }
    });

    table.on('sort(' + BusinessOutApplication.tableId + ')', function(obj){
        console.log(obj.field); //当前排序的字段名
        console.log(obj.type); //当前排序类型：desc（降序）、asc（升序）、null（空对象，默认排序）
        console.log(this);


        table.reload('idTest', {
            initSort: obj
            ,where: {
                field: obj.field
                ,order: obj.type
            }
        });

    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        BusinessOutApplication.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        BusinessOutApplication.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        BusinessOutApplication.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + BusinessOutApplication.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            BusinessOutApplication.openEditDlg(data);
        } else if (layEvent === 'delete') {
            BusinessOutApplication.onDeleteItem(data);
        } else if (layEvent === 'download') {
            layer.open({
                type: 2,
                title: false,
                closeBtn: 0, //不显示关闭按钮
                shade: [0],
                area: ['1px', '1px'],
                offset: 'rb',
                time: 1000,
                anim: 2,
                content: [Feng.ctxPath + '/businessOutApplication/export?id=' + data.id, 'no'],
            });
        } else if (layEvent === 'sy') {
            layer.open({
                type: 2,
                title: false,
                closeBtn: 0,
                shade: [0],
                area: ['1px', '1px'],
                offset: 'rb',
                time: 1000,
                anim: 2,
                content: [Feng.ctxPath + '/businessOutApplication/sy?id=' + data.id, 'no'],
                success: function(layero, index){
                    table.reload('bt');
                }
            });
        } else if (layEvent === 'pf') {
            layer.open({
                type: 2,
                title: false,
                closeBtn: 0,
                shade: [0],
                area: ['1px', '1px'],
                offset: 'rb',
                time: 1000,
                anim: 2,
                content: [Feng.ctxPath + '/businessOutApplication/pf?id=' + data.id, 'no'],
                success: function(layero, index){
                    table.reload('bt');
                }
            });
        } else if (layEvent === 'dh') {
            layer.open({
                type: 2,
                title: false,
                closeBtn: 0,
                shade: [0],
                area: ['1px', '1px'],
                offset: 'rb',
                time: 1000,
                anim: 2,
                content: [Feng.ctxPath + '/businessOutApplication/dh?id=' + data.id, 'no'],
                success: function(layero, index){
                    table.reload('bt');
                }
            });
        } else if (layEvent === 'jj') {
            layer.open({
                type: 2,
                title: false,
                closeBtn: 0,
                shade: [0],
                area: ['1px', '1px'],
                offset: 'rb',
                time: 1000,
                anim: 2,
                content: [Feng.ctxPath + '/businessOutApplication/jj?id=' + data.id, 'no'],
                success: function(layero, index){
                    table.reload('bt');
                }
            });
        } else if (layEvent === 'gx') {
            func.open({
                title: '修改',
                content: Feng.ctxPath + '/businessOutApplication/eapp?id=' + data.id,
                tableId: 'bt'
            });
        }
    });
});
