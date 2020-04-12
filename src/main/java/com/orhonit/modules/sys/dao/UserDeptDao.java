package com.orhonit.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.sys.entity.UserDeptEntity;
import com.orhonit.modules.sys.vo.IdAndNameVo;
import com.orhonit.modules.sys.vo.TreeVo;

/**
 * 用户支部信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-08 09:43:09
 */
@Mapper
public interface UserDeptDao extends BaseMapper<UserDeptEntity> {

	List<IdAndNameVo> ListByLike(@Param("deptName")String deptName);

	List<TreeVo> getDeptList();

	IdAndNameVo selectDeptById(@Param("deptId")Integer deptId);

	IdAndNameVo selectOrgById(@Param("orgId")Integer orgId);

	
}
