/**
 * 初始化模型管理详情对话框
 */
var ModuleInfoDlg = {
    ModuleInfoData : {},
    // 校验条件
    validateFields: {
    }
};
var requestBaseUrl = "/requirement/module";

/**
 * 清除数据
 */
ModuleInfoDlg.clearData = function() {
    this.ModuleInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ModuleInfoDlg.set = function(key, val) {
    this.ModuleInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ModuleInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ModuleInfoDlg.close = function() {
    parent.layer.close(window.parent.Module.layerIndex);
}

/**
 * 收集数据
 */
ModuleInfoDlg.collectData = function() {
    this.set('id').set('modelName').set('useScope').set('description');
}

/**
 * 验证数据是否为空
 */
ModuleInfoDlg.validate = function () {
    $('#moduleForm').data("bootstrapValidator").resetForm();
    $('#moduleForm').bootstrapValidator('validate');
    return $("#moduleForm").data('bootstrapValidator').isValid();
}

/**
 * 提交添加
 */
ModuleInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + requestBaseUrl+"/add", function(data){
        Feng.success("添加成功!");
        window.parent.Module.table.refresh();
        ModuleInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ModuleInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ModuleInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    if (!this.validate()) {
        return;
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + requestBaseUrl+"/update", function(data){
        Feng.success("修改成功!");
        window.parent.Module.table.refresh();
        ModuleInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ModuleInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("moduleForm", ModuleInfoDlg.validateFields);
});
