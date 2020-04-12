package com.orhonit.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.app.entity.AppNewsCommentReplyEntity;

import java.util.Map;

/**
 * 回复评论表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-01-22 14:10:06
 */
public interface AppNewsCommentReplyService extends IService<AppNewsCommentReplyEntity> {

    PageUtils queryPage(Map<String, Object> params);

	void replyCount(Integer comId);
}

