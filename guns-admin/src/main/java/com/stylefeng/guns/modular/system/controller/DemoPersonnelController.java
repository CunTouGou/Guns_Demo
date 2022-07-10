package com.stylefeng.guns.modular.system.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.Tip;
import com.stylefeng.guns.core.common.exception.BizExceptionEnum;
import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.modular.system.model.Dict;
import com.stylefeng.guns.modular.system.service.IDictService;
import com.stylefeng.guns.modular.system.warpper.PersonneWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.DemoPersonnel;
import com.stylefeng.guns.modular.system.service.IDemoPersonnelService;

import java.util.List;
import java.util.Map;

/**
 * 人员管理控制器
 *
 * @author fengshuonan
 * @Date 2022-07-10 14:13:14
 */
@Controller
@RequestMapping("/demoPersonnel")
public class DemoPersonnelController extends BaseController {

    private String PREFIX = "/system/personnel/";

    @Autowired
    private IDemoPersonnelService demoPersonnelService;

    @Autowired
    private IDictService dictService;

    /**
     * 跳转到人员管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "demoPersonnel.html";
    }

    /**
     * 跳转到添加人员管理
     */
    @RequestMapping("/demoPersonnel_add")
    public String demoPersonnelAdd(Model model) {
        List<Dict> hobbyList = dictService.selectByParentCode("per_hobby");
        model.addAttribute("hobbyList", hobbyList);
        LogObjectHolder.me().set(hobbyList);
        return PREFIX + "demoPersonnel_add.html";
    }

    /**
     * 跳转到修改人员管理
     */
    @RequestMapping("/demoPersonnel_update/{demoPersonnelId}")
    public String demoPersonnelUpdate(@PathVariable Integer demoPersonnelId, Model model) {
        DemoPersonnel demoPersonnel = demoPersonnelService.selectById(demoPersonnelId);
        List<Dict> hobbyList = dictService.selectByParentCode("per_hobby");
        model.addAttribute("personnel", demoPersonnel);
        model.addAttribute("hobbyList", hobbyList);
        LogObjectHolder.me().set(demoPersonnel);
        LogObjectHolder.me().set(hobbyList);
        return PREFIX + "demoPersonnel_edit.html";
    }

    /**
     * 获取人员管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list() {
        List<Map<String, Object>> personnelList = demoPersonnelService.list();
        return new PersonneWarpper(personnelList).warp();
    }

    /**
     * 新增人员管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Tip add(DemoPersonnel personnel, BindingResult result) {
        if (result.hasErrors()){
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        demoPersonnelService.insert(personnel);
        return SUCCESS_TIP;
    }

    /**
     * 删除人员管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer demoPersonnelId) {
        demoPersonnelService.deleteById(demoPersonnelId);
        return SUCCESS_TIP;
    }

    /**
     * 修改人员管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(DemoPersonnel demoPersonnel) {
        demoPersonnelService.updateById(demoPersonnel);
        return SUCCESS_TIP;
    }

    /**
     * 人员管理详情
     */
    @RequestMapping(value = "/detail/{demoPersonnelId}")
    @ResponseBody
    public Object detail(@PathVariable("demoPersonnelId") Integer demoPersonnelId) {
        return demoPersonnelService.selectById(demoPersonnelId);
    }
}
