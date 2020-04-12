package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.NewsCommentEntity;

import java.util.Map;

/**
 * 新闻评论表
 *
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-15 09:58:02
 */
public interface NewsCommentService extends IService<NewsCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);

	PageUtils personalcomment(Map<String, Object> params, Long userId);
}

