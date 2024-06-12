/**
 * 管理初始化
 */
var TableInfo = {
    id: "TableInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TableInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'Id', field: 'id', align: 'center', valign: 'middle'},
        {title: '功能', field: 'content', align: 'center', valign: 'middle'},
        {title: '表名', field: 'tableName', align: 'center', valign: 'middle'},
        {title: '类名', field: 'className', align: 'center', valign: 'middle'},
        {title: '模板组', field: 'group', align: 'center', valign: 'middle',formatter:function (value, row, index) {
            var option = "";
            row.templateGroupModelList.forEach(function(data,index){
                option += "<option value='"+data.id+"'>"+data.name+"</option>";
            });
            return "<select class='form-control' name='templateGroup'+"+row.id+">"+option+"</select>";
        }},
        {title: '快捷生成', align: 'center', valign: 'middle',formatter: function (value, row, index) {
            var groupId = $('input[name=groupId]').val();

            var linkBackend = "jumpBackend('"+groupId+"','"+row.id+"','"+row.content+"','"+row.className+"')";
            var linkFrontend = "jumpFrontend('"+groupId+"','"+row.id+"','"+row.content+"','"+row.className+"')";
            var linkEolink = "jumpEoLink('"+groupId+"','"+row.id+"','"+row.content+"','"+row.className+"')";
                return "<a onclick=\""+linkBackend+"\"> 后端 </a> " +
                "<a onclick=\""+linkFrontend+"\"> 前端 </a> " +
                " <a onclick=\""+linkEolink+"\"> 接口文档 </a> "
        }},
    ];
};

function jumpBackend(groupId,id,content,className){
    layer.prompt({title: '请输入包名'}, function(text, index){
        layer.close(index);
        window.open("/code/review_code_backend?groupId="+groupId+"&tableId="+id+"&author=code-general&name="+content+"&codePackage="+text+"&entityName="+className,"_blank");
    });
}
function jumpFrontend(groupId,id,content,className){
    layer.prompt({title: '请输入接口前缀'}, function(text, index){
        layer.close(index);
        window.open("/code/review_code_frontend?groupId="+groupId+"&tableId="+id+"&author=code-general&name="+content+"&codePackage="+text+"&entityName="+className,"_blank");
    });
}
function jumpEoLink(groupId,id,content,className){
    layer.prompt({title: '请求基础路径BaseUrl'}, function(text, index){
        layer.close(index);
        window.open("/code/review_code_eolink?groupId="+groupId+"&tableId="+id+"&author=code-general&name="+content+"&codePackage="+text+"&entityName="+className,"_blank");
    });
}



/**
 * 检查是否选中
 */
TableInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        TableInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
TableInfo.openAddTableInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['100%', '100%'],//宽高
        fix: false, //不固定
        maxmin: true,
        shade: 0,
        anim: 2,
        content: Feng.ctxPath + '/tableinfo/goto_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看编辑
 */
TableInfo.openTableInfoEdit = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '修改',
            area: ['100%', '100%'],//宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tableinfo/goto_update/'
            + TableInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
TableInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tableinfo/delete", function (data) {
            Feng.success("删除成功!");
            TableInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id", this.seItem.id);
        ajax.start();
    }
};

/**
 * DB导入-from table
 */
TableInfo.dbimport = function () {
    var index = layer.open({
        type: 2,
        title: 'DB导入',
        area: ['100%', '100%'],//宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tableinfo/goto_dbimport/'
    });
    this.layerIndex = index;
};

/**
 * 导入-from sql
 */
TableInfo.sqlimport = function () {
    var index = layer.open({
        type: 2,
        title: 'SQL导入',
        area: ['100%', '100%'],//宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tableinfo/goto_sqlimport/',
        cancel: function (index, layero) {
            TableInfo.search();
        }
    });
    this.layerIndex = index;
};

/**
 * 代码生成
 */
TableInfo.gen = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '代码生成',
            area: ['100%', '100%'],//宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/code/tableGen/' + TableInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 字典生成
 */
TableInfo.genDoc = function () {
    var index = layer.open({
        type: 2,
        title: '代码生成',
        area: ['100%', '100%'],//宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tableinfo/genDoc'
    });
    this.layerIndex = index;
};

TableInfo.formParams = function () {
    var queryData = {};
    return queryData;
};

/**
 * 查询列表
 */
TableInfo.search = function () {
    var queryData = {};
    queryData['content'] = $("#content").val();
    queryData['tableName'] = $("#tableName").val();
    queryData['className'] = $("#className").val();
    TableInfo.table.refresh({query: queryData});
};

TableInfo.getIsOrNotName = function (value, row, index) {
    if (value == 1) {
        return '是';
    } else {
        return '否';
    }
}

$(function () {
    var defaultColunms = TableInfo.initColumn();
    var table = new BSTable(TableInfo.id, "/tableinfo/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(TableInfo.formParams());
    TableInfo.table = table.init();
});