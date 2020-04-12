package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.UserRouteEntity;

import java.util.List;
import java.util.Map;

/**
 * 乘车路线表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-11 17:21:10
 */
public interface UserRouteService extends IService<UserRouteEntity> {

    PageUtils queryPage(Map<String, Object> deptId);

	List<UserRouteEntity> getRouteList(int deptId);

	void deleteRoute(Integer routeId);
}

