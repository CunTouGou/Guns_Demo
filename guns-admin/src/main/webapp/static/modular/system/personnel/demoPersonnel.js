/**
 * 人员管理管理初始化
 */
var DemoPersonnel = {
    id: "DemoPersonnelTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DemoPersonnel.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: false, align: 'center', valign: 'middle'},
            {title: '名字', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'sexName', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'statusName', visible: true, align: 'center', valign: 'middle'},
            {title: '爱好', field: 'hobbyName', visible: true, align: 'center', valign: 'middle'},
            {title: '个人介绍', field: 'profile', visible: true, align: 'center', valign: 'middle'},
            {title: '相片', field: 'photo', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
DemoPersonnel.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DemoPersonnel.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加人员管理
 */
DemoPersonnel.openAddDemoPersonnel = function () {
    var index = layer.open({
        type: 2,
        title: '添加人员管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/demoPersonnel/demoPersonnel_add'
    });
    this.layerIndex = index;
};

/**
 * 点击修改人员管理
 * @param PersonnelId 用户Id
 */
DemoPersonnel.openChangePersonnel = function () {
    if (this.check()){
        var index = layer.open({
            type: 2,
            title: '编辑人员管理',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/demoPersonnel/demoPersonnel_update/' + DemoPersonnel.seItem.id
        });
        this.layerIndex = index;
    }
}

/**
 * 删除人员管理
 */
DemoPersonnel.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/demoPersonnel/delete", function (data) {
            Feng.success("删除成功!");
            DemoPersonnel.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("demoPersonnelId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询人员管理列表
 */
DemoPersonnel.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DemoPersonnel.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DemoPersonnel.initColumn();
    var table = new BSTable(DemoPersonnel.id, "/demoPersonnel/list", defaultColunms);
    table.setPaginationType("client");
    DemoPersonnel.table = table.init();
});
