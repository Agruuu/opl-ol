package com.orhonit.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.app.entity.NewsCollcetionEntity;

import java.util.Map;

/**
 * 新闻收藏表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-04-02 14:45:15
 */
public interface NewsCollcetionService extends IService<NewsCollcetionEntity> {

    PageUtils queryPage(Map<String, Object> params,long userId);
}

