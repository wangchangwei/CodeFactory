/**
 * 页面管理管理初始化
 */
var Page = {
    id: "PageTable",	//表格id
        seItem: null,		//选中的条目
        table: null,
        layerIndex: -1
};

Page.requestBaseUrl = "/requirement"+"/page";
/**
 * 初始化表格的列
 */
Page.initColumn = function () {
    return [
           {field: 'selectItem', radio: true},
           {title: 'id', field: 'id', align: 'center', valign: 'middle'},
           {title: '页面名称', field: 'pageName', align: 'center', valign: 'middle'},
           {title: '页面类型', field: 'pageType', align: 'center', valign: 'middle'},
           {title: '页面数量', field: 'pageElementCount', align: 'center', valign: 'middle'},
           {title: '模型名称', field: 'moduleName', align: 'center', valign: 'middle'},
           {title: '原型图', field: 'files', align: 'center', valign: 'middle',formatter: function (value, row, index) {
                  var data = "";
                  if(value!=""){
                        var file = value.split(';');
                        file.forEach(function(item){
                            if (item!=null){
                               data += "<a class='fancybox' target='_blank' href='"+Feng.ctxPath+"/kaptcha/"+item+"' > <img alt='image' style='width:50px' src='"+Feng.ctxPath+"/kaptcha/"+item+"'> </a>";
                            }
                        });
                  }
                  return data;
           }},
            {title: '操作', align: 'center', valign: 'middle',formatter: function (value, row, index) {
                   var linkBackend = "jumpPage('"+row.id+"')";
                   var uploadPicture = "uploadPicture('"+row.id+"')";
                   return "<a onclick=\""+linkBackend+"\"> 元素管理 </a> ";
            }},
       ];
};

/**
* 跳转到页面管理
*/
function jumpPage(id){
    window.open("/requirement/element?pageId="+id,"_blank");
}
/**
* 跳转到页面管理
*/
function jumpPage(id){
     var index = layer.open({
            type: 2,
            title: '元素管理',
            area: ['100%', '100%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/requirement/element?pageId='+id
     });
}


/**
 * 检查是否选中
 */
Page.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Page.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加页面管理
 */
Page.openAddPage = function () {
    var index = layer.open({
        type: 2,
        title: '添加页面管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + Page.requestBaseUrl +'/goto_add?moduleId='+Page.moduleId
    });
    this.layerIndex = index;
};

/**
 * 打开查看页面管理详情
 */
Page.openPageDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '页面管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath +Page.requestBaseUrl + '/goto_update/' + Page.seItem.id
    });
        this.layerIndex = index;
    }
};

/**
 * 删除页面管理
 */
Page.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + Page.requestBaseUrl +"/delete", function (data) {
            Feng.success("删除成功!");
            Page.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",this.seItem.id);
        ajax.start();
    }
};

Page.formParams = function() {
    var queryData = {moduleId:Page.moduleId};
    return queryData;
};

/**
 * 查询页面管理列表
 */
Page.search = function () {
    var queryData = {};

    Page.table.refresh({query: queryData});
}
$(function () {
    var defaultColumns  = Page.initColumn();
    var table = new BSTable(Page.id, Page.requestBaseUrl+"/list", defaultColumns );
    table.setPaginationType("server");
    table.setQueryParams(Page.formParams());
    Page.table = table.init();

    var webUpload = new $WebUpload("picker");
    webUpload.setUploadUrl(Feng.ctxPath + '/requirement/page/upload');
    var uploader =  webUpload.init();
     uploader.on('uploadBeforeSend', function(obj, data, headers) {
           Page.check();
           data.bizId = Page.seItem.id
     });
});
