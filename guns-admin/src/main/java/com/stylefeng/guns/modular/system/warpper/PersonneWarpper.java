package com.stylefeng.guns.modular.system.warpper;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author CunTouGou
 * @date 2022/7/10 15:33
 */

public class PersonneWarpper extends BaseControllerWarpper {

    public PersonneWarpper(Object obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("sexName", ConstantFactory.me().getSexName((Integer) map.get("sex")));
        map.put("statusName", ConstantFactory.me().getDictsByName("状态", (Integer) map.get("status")));

        String hobbyIds = (String) map.get("hobby");
        if (StringUtils.isNotEmpty(hobbyIds)) {
            String[] hobbyList = hobbyIds.split(",");
            String hobbyStr = "";
            for (String s : hobbyList) {
                hobbyStr = ConstantFactory.me().getDictsByName("爱好", Integer.parseInt(s)) + " " + hobbyStr;
            }
            map.put("hobbyName", hobbyStr);
        }
    }
}
