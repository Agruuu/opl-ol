package com.orhonit.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.sys.entity.MyrequestEntity;
import com.orhonit.modules.sys.vo.MyrequestEntityVo;

/**
 * 我的述求
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-25 16:47:20
 */
@Mapper
public interface MyrequestDao extends BaseMapper<MyrequestEntity> {

	MyrequestEntityVo selectInfoMyrequest(@Param("myreqId")Integer myreqId);
	
}
