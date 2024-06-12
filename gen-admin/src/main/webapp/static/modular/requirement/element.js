/**
 * 元素管理管理初始化
 */
var Element = {
    id: "ElementTable",	//表格id
        seItem: null,		//选中的条目
        table: null,
        layerIndex: -1
};
var requestBaseUrl = "/requirement/element";

/**
 * 初始化表格的列
 */
Element.initColumn = function () {
    return [
            {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', align: 'center', valign: 'middle'},
        {title: '元素名称', field: 'elementName', align: 'center', valign: 'middle'},
        {title: '元素类型', field: 'elementType', align: 'center', valign: 'middle'},
        {title: '元素规则', field: 'elementRules', align: 'center', valign: 'middle'},
        {title: '选择类型', field: 'checkType', align: 'center', valign: 'middle'},
        {title: '字典名称', field: 'dictName', align: 'center', valign: 'middle'},
        {title: '交互方式', field: 'interactiveMethods', align: 'center', valign: 'middle'},
        {title: '触发事件', field: 'triggerEvent', align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
Element.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Element.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加元素管理
 */
Element.openAddElement = function () {
    var pageId = $('input[name=pageId]').val();
    var index = layer.open({
        type: 2,
        title: '添加元素管理',
        area: ['840px', '600px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + requestBaseUrl +'/goto_add?pageId='+pageId
    });
    this.layerIndex = index;
};

/**
 * 打开查看元素管理详情
 */
Element.openElementDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '元素管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath +requestBaseUrl + '/goto_update/' + Element.seItem.id
    });
        this.layerIndex = index;
    }
};

/**
 * 删除元素管理
 */
Element.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + requestBaseUrl +"/delete", function (data) {
            Feng.success("删除成功!");
            Element.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",this.seItem.id);
        ajax.start();
    }
};

Element.formParams = function() {
    var pageId = $('input[name=pageId]').val();
    var queryData = {pageId:pageId};
    return queryData;
};

/**
 * 查询元素管理列表
 */
Element.search = function () {
    var queryData = {};

    Element.table.refresh({query: queryData});
};

$(function () {
    var defaultColumns = Element.initColumn();
    var table = new BSTable(Element.id, requestBaseUrl +"/list", defaultColumns );
    table.setPaginationType("server");
    table.setQueryParams(Element.formParams());
    Element.table = table.init();
});
