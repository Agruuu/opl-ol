package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.UserStationEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户车站表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-13 10:14:11
 */
public interface UserStationService extends IService<UserStationEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<UserStationEntity> getStationList(Integer routeId);
}

