/**
 * 初始化页面管理详情对话框
 */
var PageInfoDlg = {
    PageInfoData : {},
    // 校验条件
    validateFields: {
    }
};

var requestBaseUrl = "/requirement/page";

/**
 * 清除数据
 */
PageInfoDlg.clearData = function() {
    this.PageInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PageInfoDlg.set = function(key, val) {
    this.PageInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PageInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PageInfoDlg.close = function() {
    parent.layer.close(window.parent.Page.layerIndex);
}

/**
 * 收集数据
 */
PageInfoDlg.collectData = function() {
    this.set('id').set('pageName').set('pageType').set('pageElementCount').set('moduleId');
}

/**
 * 验证数据是否为空
 */
PageInfoDlg.validate = function () {
    $('#pageForm').data("bootstrapValidator").resetForm();
    $('#pageForm').bootstrapValidator('validate');
    return $("#pageForm").data('bootstrapValidator').isValid();
}



/**
 * 提交添加
 */
PageInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath +requestBaseUrl+ "/add", function(data){
        Feng.success("添加成功!");
        window.parent.Page.table.refresh();
        PageInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.PageInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PageInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath +requestBaseUrl+ "/update", function(data){
        Feng.success("修改成功!");
        window.parent.Page.table.refresh();
        PageInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.PageInfoData);
    ajax.start();
}



$(function() {
    Feng.initValidator("pageForm", PageInfoDlg.validateFields);
});
