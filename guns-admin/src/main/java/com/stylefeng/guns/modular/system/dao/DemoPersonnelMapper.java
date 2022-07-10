package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.DemoPersonnel;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author doll
 * @since 2022-07-10
 */
public interface DemoPersonnelMapper extends BaseMapper<DemoPersonnel> {

    List<Map<String, Object>> list();
}
