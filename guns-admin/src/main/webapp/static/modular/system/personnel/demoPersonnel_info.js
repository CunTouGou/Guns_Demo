/**
 * 初始化人员管理详情对话框
 */
var DemoPersonnelInfoDlg = {
    demoPersonnelInfoData : {
    }
};

/**
 * 清除数据
 */
DemoPersonnelInfoDlg.clearData = function() {
    this.demoPersonnelInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DemoPersonnelInfoDlg.set = function(key, val) {
    if(typeof value == "undefined"){
        if(typeof $("#" + key).val() =="undefined"){
            var str="";
            var ids="";
            $("input[name='"+key+"']:checkbox").each(function(){
                if(true == $(this).is(':checked')){
                    str+=$(this).val()+",";
                }
            });
            if(str){
                if(str.substr(str.length-1)== ','){
                    ids = str.substr(0,str.length-1);
                }
            }else{
                $("input[name='"+key+"']:radio").each(function(){
                    if(true == $(this).is(':checked')){
                        ids=$(this).val()
                    }
                });
            }
            this.demoPersonnelInfoData[key] = ids;
        }else{
            this.demoPersonnelInfoData[key]= $("#" + key).val();
        }
    }
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DemoPersonnelInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DemoPersonnelInfoDlg.close = function() {
    parent.layer.close(window.parent.DemoPersonnel.layerIndex);
}

/**
 * 收集数据
 */
DemoPersonnelInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('sex')
    .set('status')
    .set('hobby')
    .set('profile')
    .set('photo');
}

/**
 * 提交添加
 */
DemoPersonnelInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/demoPersonnel/add", function(data){
        Feng.success("添加成功!");
        window.parent.DemoPersonnel.table.refresh();
        DemoPersonnelInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.demoPersonnelInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DemoPersonnelInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/demoPersonnel/update", function(data){
        Feng.success("修改成功!");
        window.parent.DemoPersonnel.table.refresh();
        DemoPersonnelInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.demoPersonnelInfoData);
    ajax.start();
}

$(function () {
    //初始化性别选项
    $("#sex").val($("#sexValue").val());

    $("#status").val($("#statusValue").val());

    // 初始化头像上传
    var avatarUp = new $WebUpload("avatar");
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();
});