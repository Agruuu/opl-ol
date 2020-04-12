package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.entity.UserRouteEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 乘车路线表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-11 17:21:10
 */
@Mapper
public interface UserRouteDao extends BaseMapper<UserRouteEntity> {

	List<UserRouteEntity> getRouteList(@Param("deptId")int deptId);

	void deleteStations(@Param("routeId")Integer routeId);
	
}
