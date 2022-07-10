package com.stylefeng.guns.modular.system.service;

import com.stylefeng.guns.modular.system.model.DemoPersonnel;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author doll
 * @since 2022-07-10
 */
public interface IDemoPersonnelService extends IService<DemoPersonnel> {
    List<Map<String, Object>> list();
}
