/**
 * 管理初始化
 */
var ErrorCode = {
    id: "ErrorCodeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ErrorCode.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', align: 'center', valign: 'middle',visible: false},
        {title: '编码', field: 'code', align: 'center', valign: 'middle'},
	     {title: '中文', field: 'cnText', align: 'center', valign: 'middle'},
	     {title: '英文code', field: 'enText', align: 'center', valign: 'middle'},
        {title: 'Java代码', align: 'center', valign: 'middle',formatter: function (value, row, index) {
                return row.enText.toUpperCase()+"("+row.code+",\""+row.cnText+"\",\""+row.enText+"\"),";
        }},
    ];
};

/**
 * 检查是否选中
 */
ErrorCode.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ErrorCode.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
ErrorCode.openAddErrorCode = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/errorcode/goto_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
ErrorCode.openErrorCodeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/errorcode/goto_update/' + ErrorCode.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
ErrorCode.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/errorcode/delete", function (data) {
            Feng.success("删除成功!");
            ErrorCode.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 导出
 */
ErrorCode.export = function () {
    window.open(Feng.ctxPath + "/errorcode/export");
};

ErrorCode.formParams = function() {
    var queryData = {};
    return queryData;
};

/**
 * 查询列表
 */
ErrorCode.search = function () {
    var queryData = {};
    queryData['cnText'] = $("#condition").val();
    queryData['enText'] = $("#condition").val();
    ErrorCode.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ErrorCode.initColumn();
    var table = new BSTable(ErrorCode.id, "/errorcode/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(ErrorCode.formParams());
    ErrorCode.table = table.init();
});
