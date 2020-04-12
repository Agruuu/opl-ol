package com.orhonit.modules.app.dao;

import com.orhonit.modules.app.entity.AppNewsThumbsupEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-01-23 14:34:36
 */
@Mapper
public interface AppNewsThumbsupDao extends BaseMapper<AppNewsThumbsupEntity> {

	void updateNewZan(@Param("newId")Integer newId);
	
}
