package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.entity.WelcomeNewpEntity;
import com.orhonit.modules.sys.vo.WelcomeNewpVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 欢迎新成员表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-28 16:30:54
 */
@Mapper
public interface WelcomeNewpDao extends BaseMapper<WelcomeNewpEntity> {

	void insertSelect(@Param("newpUserId")long newpUserId,@Param("deptId")Integer deptId);

	List<WelcomeNewpEntity> selectWelList(@Param("beginLimit")int beginLimit, @Param("limit")int limit, @Param("userId")long userId);

	WelcomeNewpVo selectNewpById(@Param("newpId")Integer newpId);
	
}
