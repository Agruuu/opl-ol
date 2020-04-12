package com.orhonit.modules.app.dao;

import com.orhonit.modules.app.entity.AppUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-27 10:38:42
 */
@Mapper
public interface AppUserDao extends BaseMapper<AppUserEntity> {
	
}
