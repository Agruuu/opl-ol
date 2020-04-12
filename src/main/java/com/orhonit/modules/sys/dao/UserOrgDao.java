package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.entity.UserOrgEntity;
import com.orhonit.modules.sys.vo.IdAndNameVo;
import com.orhonit.modules.sys.vo.TreeVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * app用户所在单位表
 * 
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-14 16:29:13
 */
@Mapper
public interface UserOrgDao extends BaseMapper<UserOrgEntity> {

	List<TreeVo> getOrgList();

	List<IdAndNameVo> ListByLike(@Param("orgName")String orgName);

	IdAndNameVo getOrgByOrgId(@Param("userOrg")int userOrg);

	List<IdAndNameVo> getDeptByOrgId(@Param("userOrg")int userOrg);
	
}
