/**
 * 模型管理管理初始化
 */
var Module = {
    id: "ModuleTable",	//表格id
        seItem: null,		//选中的条目
        table: null,
        layerIndex: -1
};

Module.requestBaseUrl = "/requirement/module";

/**
 * 初始化表格的列
 */
Module.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', align: 'center', valign: 'middle'},
        {title: '模型名称', field: 'modelName', align: 'center', valign: 'middle'},
        {title: '使用范围', field: 'useScope', align: 'center', valign: 'middle'},
        {title: '业务描述', field: 'description', align: 'center', valign: 'middle'},
    ];
};


/**
 * 检查是否选中
 */
Module.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Module.seItem = selected[0];
        return true;
    }
};



/**
 * 点击添加模型管理
 */
Module.openAddModule = function () {
    var index = layer.open({
        type: 2,
        title: '添加模型管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + Module.requestBaseUrl+'/goto_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看模型管理详情
 */
Module.openModuleDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '模型管理详情',
            area: ['420px', '800px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + Module.requestBaseUrl+'/goto_update/' + Module.seItem.id
    });
        this.layerIndex = index;
    }
};

/**
 * 删除模型管理
 */
Module.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath +Module.requestBaseUrl+ "/delete", function (data) {
            Feng.success("删除成功!");
            Module.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",this.seItem.id);
        ajax.start();
    }
};

Module.formParams = function() {
    var queryData = {};
    return queryData;
};

/**
 * 查询模型管理列表
 */
Module.search = function () {
    var queryData = {};
    queryData['id'] = $("#id").val();
    queryData['description'] = $("#description").val();
    Module.table.refresh({query: queryData});
};

$(function () {
    var defaultColumns = Module.initColumn();
    var table = new BSTable(Module.id, "/requirement/module/list", defaultColumns);
    table.setPaginationType("server");
    table.setQueryParams(Module.formParams());
    Module.table = table.init();
    $('#ModuleTable').on('check.bs.table', function (e,row, $element) {
          Page.table.refresh({query: {moduleId:row.id}});
          Page.moduleId = row.id;
    });
});
