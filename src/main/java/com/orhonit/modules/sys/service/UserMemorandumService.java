package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.UserMemorandumEntity;

import java.util.Map;

/**
 * 用户备忘录表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-03-04 14:35:59
 */
public interface UserMemorandumService extends IService<UserMemorandumEntity> {

    PageUtils queryPage(Map<String, Object> params,long userId);
}

