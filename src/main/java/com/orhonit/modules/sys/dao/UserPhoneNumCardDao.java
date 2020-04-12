package com.orhonit.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.sys.entity.UserPhoneNumCardEntity;

/**
 * 用户手机识别码表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-03-04 10:13:59
 */
@Mapper
public interface UserPhoneNumCardDao extends BaseMapper<UserPhoneNumCardEntity> {

	int updateByLoginUserId(UserPhoneNumCardEntity userPhoneNumCard);

	UserPhoneNumCardEntity selectByUserId(@Param("userId")long userId);
	
	//根据支部查询手机识别码集合
	List<String> selectByDeptId(@Param("deptId")int deptId);
	//根据部门查询手机识别码集合
	List<String> selectByOrgId(@Param("orgId")int deptId);
	//根据地区查询手机识别码集合
	List<String> selectByareaId(@Param("areaId")String areaId);
}
