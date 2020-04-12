package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.WelcomeNewpEntity;
import com.orhonit.modules.sys.vo.WelcomeNewpVo;

import java.util.Map;

/**
 * 欢迎新成员表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-28 16:30:54
 */
public interface WelcomeNewpService extends IService<WelcomeNewpEntity> {

    PageUtils queryPage(Map<String, Object> params,long userId);

    WelcomeNewpVo selectNewpById(Integer newpId);
}

