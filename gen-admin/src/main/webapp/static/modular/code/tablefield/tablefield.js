/**
 * 管理初始化
 */
var TableField = {};

TableField.trClink = function () {
    $("#fieldInfoDiv").find('.fieldNav').each(function () {
        $(this).css('display','none');
    });
    var maxId = $(this).attr("id").replace('fieldTr', '');
    $("#fieldNav"+maxId).css('display','');
}

TableField.fieldAdd = function () {
    var id=$('#tableId').val();
    var maxId = $(
        $("#tableField").find('tbody').find('tr')[$("#tableField").find('tbody').find('tr').length
                                                  - 1]).attr("id");
    if (maxId && maxId != undefined ) {
        maxId = maxId.replace('fieldTr', '')
        maxId = parseInt(maxId) + 1;
    } else {
        maxId = 1;
    }
    //初始化数据
    // var tr = $("#tableField tbody tr").eq(0).clone();
    // $(tr).find('[type="checkbox"]').each(function () {
    //     $(this).removeAttr("checked");
    // });
    // $(tr).find('[type="text"]').each(function () {
    //     $(this).val('');
    // });
    // $(tr).find('select').each(function () {
    //     $(this).find("option:selected").attr("selected", false);
    //     $(this).find("option").first().attr("selected", true);
    // });
//    var tr =  "<tr id='fieldTr'"+maxId+"  class='fieldTr' style='background: rgb(255, 255, 255);'><td style='display: none' type='hidden' data-field='id'><input style='display:none' type='text' class='form-control' name='id' value=''></td><td style='text-align: center; vertical-align: middle; 'data-field='ignore'><div class='th-inner '><span style='cursor:pointer;'class='glyphicon glyphicon-minus fieldTrRemove'></span></div></td><td style='text-align: center; vertical-align: middle;width: 70px; 'data-field='orderNum'><div class='td-inner '><input type='text' class='form-control' value='"+maxId+"' placeholder='排序'></div></td><td style='text-align: center; vertical-align: middle; 'data-field='content'><div class='td-inner '><input type='text'class='form-control content'required=''placeholder='功能'value='Id'></div></td><td style='text-align: center; vertical-align: middle; 'data-field='fieldName'><div class='td-inner '><input type='text' class='form-control required' name='fieldName' placeholder='数据库字段名称' value=''></div></td><td style='text-align: center; vertical-align: middle; 'data-field='name'><div class='td-inner '><input type='text' class='form-control required' name='name' placeholder='代码字段名称'value='id'></div></td><td style='text-align: center; vertical-align: middle; 'data-field='type'><div class='td-inner '><div class=''><select class='form-control'id='type_5067'name='type_5067'><option value='String'>String</option><option value='Boolean'>Boolean</option><option value='Integer'>Integer</option><option value='Float'>Float</option><option value='Double'>Double</option><option value='BigDecimal'>BigDecimal</option><option value='Date'>Date</option><option value='byte'>byte</option><option value='byte[]'>byte[]</option><option value='Object'>Object</option><option value='Long'>Long</option></select></div></div></td></tr>";
    var tr = "<tr id='fieldTr"+maxId+"' class='fieldTr'><td style='text-align: center; vertical-align: middle; 'data-field='ignore'><div class='th-inner '><span style='cursor:pointer;'class='glyphicon glyphicon-minus fieldTrRemove'></span></div></td><td style='text-align: center; vertical-align: middle;width: 70px; 'data-field='orderNum'><div class='td-inner '><input type='text' class='form-control' value='"+maxId+"' placeholder='排序'></div></td><td style='text-align: center; vertical-align: middle; 'data-field='content'><div class='td-inner '><input type='text'class='form-control content'required placeholder='功能'></div></td><td style='text-align: center; vertical-align: middle; 'data-field='fieldName'><div class='td-inner '><input type='text'class='form-control required'name='fieldName'placeholder='数据库字段名称'></div></td><td style='text-align: center; vertical-align: middle; 'data-field='name'><div class='td-inner '><input type='text'class='form-control required'name='name'placeholder='代码字段名称'></div></td><td style='text-align: center; vertical-align: middle; 'data-field='type'><div class='td-inner '><select id='type_' class='form-control'><option value='String'>String</option><option value='Boolean'>Boolean</option><option value='Integer'>Integer</option><option value='Float'>Float</option><option value='Double'>Double</option><option value='BigDecimal'>BigDecimal</option><option value='Date'>Date</option><option value='byte'>byte</option><option value='byte[]'>byte[]</option><option value='Object'>Object</option><option value='Long'>Long</option></#elect></div></td></tr>";
    // tr = $(tr).attr('id','fieldTr'+maxId);
    $("#tableField").find('tbody').append(tr);

    $("#fieldInfoDiv").find('.fieldNav').each(function () {
       $(this).css('display','none');
    });
    // 校验值 和 数据字段
    var div = $("#fieldInfoDiv .fieldNav").eq(0).clone();
    div = $(div).attr('id','fieldNav'+maxId);
    $(div).find('[type="text"]').each(function () {
        $(this).val('');
    });
    $(div).find('select').each(function () {
        $(this).find("option:selected").attr("selected", false);
        $(this).find("option").first().attr("selected", true);
    });
    // 设置初始化数据
    $(div).find('.tab-pane').each(function () {
        $(this).removeClass('in active');
    });
    $($(div).find('.tab-pane')[0]).addClass('in active');
    $(div).find('li').each(function () {
        $(this).removeClass('active');
    });
    $($(div).find('li')[0]).addClass('active');
    $(div).css('display','');
    $("#fieldInfoDiv").append(div);


    Array.prototype.forEach.call(document.getElementsByClassName('content'), function (inputField) {
        inputField.addEventListener('dblclick', function (e) {
            let ajax = new $ax("/dict/translate/"+ e.target.value, function (data) {
                $(e.target).parent().parent().parent().find('input[name=fieldName]').val(data.underline)
                $(e.target).parent().parent().parent().find('input[name=name]').val(data.lowCamel)
            });
            ajax.start();
        })
    });
}


TableField.fieldTrRemove = function () {
    if($("#tableField").find('tbody').find('tr').length > 1){
        $(this).parent().parent().parent().remove();
        var id = $(this).parent().parent().parent().attr('id');
        id = id.replace('fieldTr','fieldNav');
        $('#'+id).remove();
    }
}

TableField.tabSwitch = function (e) {
    e.preventDefault();
    $(this).tab('show');
    var div = $(this).parent().parent().parent();
    $(div).find('.tab-pane').each(function () {
        $(this).removeClass('in active');
    });
    $(div).find($(this).attr('href')).addClass('in active');
}

$(function () {
    $(document).on('click',".fieldTr",TableField.trClink);
//    $(document).on('click',".fieldAdd",TableField.fieldAdd);
//    $('.fieldAdd').onClick(TableField.fieldAdd);
    $(document).on('click',".fieldTrRemove",TableField.fieldTrRemove);
    $(document).on('click',".fieldNav a",TableField.tabSwitch);
});
