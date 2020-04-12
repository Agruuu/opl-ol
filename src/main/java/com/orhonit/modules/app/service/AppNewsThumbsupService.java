package com.orhonit.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.app.entity.AppNewsThumbsupEntity;

import java.util.Map;

/**
 * 
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-01-23 14:34:36
 */
public interface AppNewsThumbsupService extends IService<AppNewsThumbsupEntity> {

    PageUtils queryPage(Map<String, Object> params);

	void updateNewZan(Integer newId);
}

