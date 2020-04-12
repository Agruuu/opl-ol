package com.orhonit.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
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
public interface UserDeptService extends IService<UserDeptEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<IdAndNameVo> ListByLike(String deptName);

	List<TreeVo> getDeptTree();

	Map<String,IdAndNameVo> selectBoById(Integer deptId, Integer orgId);

}

