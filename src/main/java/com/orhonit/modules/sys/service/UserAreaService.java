package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dto.AreaDTO;
import com.orhonit.modules.sys.entity.UserAreaEntity;

import java.util.List;
import java.util.Map;

/**
 * 地区
 */
public interface UserAreaService extends IService<UserAreaEntity> {

    /**
     * 查询全部地区
     */
    List<AreaDTO> list();

    PageUtils queryPage(Map<String, Object> params);
}

