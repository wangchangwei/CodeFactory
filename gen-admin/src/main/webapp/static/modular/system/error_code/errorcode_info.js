/**
 * 初始化详情对话框
 */
var ErrorCodeInfoDlg = {
    ErrorCodeInfoData : {}
};

/**
 * 清除数据
 */
ErrorCodeInfoDlg.clearData = function() {
    this.ErrorCodeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ErrorCodeInfoDlg.set = function(key, val) {
    this.ErrorCodeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ErrorCodeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ErrorCodeInfoDlg.close = function() {
    parent.layer.close(window.parent.ErrorCode.layerIndex);
}

/**
 * 收集数据
 */
ErrorCodeInfoDlg.collectData = function() {
    this.set('id');
    this.set('cnText');
    this.set('enText');
    this.set('codeType');

}

/**
 * 提交添加
 */
ErrorCodeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/errorcode/add", function(data){
        Feng.success("添加成功!");
        window.parent.ErrorCode.table.refresh();
        ErrorCodeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    this.ErrorCodeInfoData['codeType'] = $('input[name=codeType]:checked').val();
    ajax.set(this.ErrorCodeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ErrorCodeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/errorcode/update", function(data){
        Feng.success("修改成功!");
        window.parent.ErrorCode.table.refresh();
        ErrorCodeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ErrorCodeInfoData);
    ajax.start();
}

$(function() {

});
