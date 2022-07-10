@/*
    hidden : input hidden框的id
    id : input框id
    label : 标题
    readonly : readonly属性
    clickFun : 点击事件的方法名
    style : 附加的css属性
@*/
<div class="form-group">
    <label class="col-sm-3 control-label">${label}</label>
    <div class="col-sm-9">
        <div class="checkbox i-checks">
            ${tagBody!}
        </div>
    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
<div class="hr-line-dashed"></div>
@}
