/**
 * 初始化元素管理详情对话框
 */
var ElementInfoDlg = {
    ElementInfoData : {},
    // 校验条件
    validateFields: {
    }
};

var requestBaseUrl = "/requirement/element";

/**
 * 清除数据
 */
ElementInfoDlg.clearData = function() {
    this.ElementInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ElementInfoDlg.set = function(key, val) {
    this.ElementInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ElementInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ElementInfoDlg.close = function() {
    parent.layer.close(window.parent.Element.layerIndex);
}

/**
 * 收集数据
 */
ElementInfoDlg.collectData = function() {
    this.set('id').set('moduleId').set('pageId').set('elementName').set('elementType').set('elementRules').set('checkType').set('dictName').set('interactiveMethods').set('triggerEvent');
}

/**
 * 验证数据是否为空
 */
ElementInfoDlg.validate = function () {
    $('#elementForm').data("bootstrapValidator").resetForm();
    $('#elementForm').bootstrapValidator('validate');
    return $("#elementForm").data('bootstrapValidator').isValid();
}



/**
 * 提交添加
 */
ElementInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath  +requestBaseUrl +"/add", function(data){
        Feng.success("添加成功!");
        window.parent.Element.table.refresh();
        ElementInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ElementInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ElementInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath  +requestBaseUrl + "/update", function(data){
        Feng.success("修改成功!");
        window.parent.Element.table.refresh();
        ElementInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ElementInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("elementForm", ElementInfoDlg.validateFields);
});
