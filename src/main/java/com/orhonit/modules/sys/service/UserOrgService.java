package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.UserOrgEntity;
import com.orhonit.modules.sys.vo.IdAndNameVo;
import com.orhonit.modules.sys.vo.TreeVo;

import java.util.List;
import java.util.Map;

/**
 * app用户所在单位表
 *
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-14 16:29:13
 */
public interface UserOrgService extends IService<UserOrgEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<TreeVo> getOrgTree();

	List<IdAndNameVo> ListByLike(String orgName);

	IdAndNameVo getOrgByOrgId(int userOrg);

	List<IdAndNameVo> getDeptByOrgId(int userOrg);
}

