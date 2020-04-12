package com.orhonit.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.sys.dto.AreaDTO;
import com.orhonit.modules.sys.entity.UserAreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 地区
 */
@Mapper
public interface UserAreaDao extends BaseMapper<UserAreaEntity> {

    /**
     * 查询全部地区
     */
    List<AreaDTO> list();
}
