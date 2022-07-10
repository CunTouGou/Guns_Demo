package com.stylefeng.guns.modular.system.service.impl;

import com.stylefeng.guns.modular.system.model.DemoPersonnel;
import com.stylefeng.guns.modular.system.dao.DemoPersonnelMapper;
import com.stylefeng.guns.modular.system.service.IDemoPersonnelService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author doll
 * @since 2022-07-10
 */
@Service
public class DemoPersonnelServiceImpl extends ServiceImpl<DemoPersonnelMapper, DemoPersonnel> implements IDemoPersonnelService {

    @Override
    public List<Map<String, Object>> list() {
        return this.baseMapper.list();
    }
}
