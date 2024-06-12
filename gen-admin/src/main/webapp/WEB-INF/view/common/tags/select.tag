@/*
    select标签中各个参数的说明:
    name : select的名称
    id : select的id
    underline : 是否带分割线
@*/
<div class="">
    @if(isNotEmpty(name)){
    <label class="control-label">${name}</label>
    @}
    <select class="form-control" id="${id}" name="${id}" style="${style!}"
            @if(isNotEmpty(disabled)){
            disabled
            @}
    >
        ${tagBody!}
    </select>
    @if(isNotEmpty(hidden)){
    <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
    @}
</div>
@if(isNotEmpty(underline) && underline == 'true'){
    <div class="hr-line-dashed"></div>
@}
@if(isNotEmpty(value)){
<script>$("#${id}").val("${value}");</script>
@}


