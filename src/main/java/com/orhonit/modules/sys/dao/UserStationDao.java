package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.entity.UserStationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户车站表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-13 10:14:11
 */
@Mapper
public interface UserStationDao extends BaseMapper<UserStationEntity> {

	List<UserStationEntity> getStationList(@Param("routeId")Integer routeId);
	
}
