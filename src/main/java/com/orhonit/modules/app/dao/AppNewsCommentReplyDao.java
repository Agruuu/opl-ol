package com.orhonit.modules.app.dao;

import com.orhonit.modules.app.entity.AppNewsCommentReplyEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 回复评论表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-01-22 14:10:06
 */
@Mapper
public interface AppNewsCommentReplyDao extends BaseMapper<AppNewsCommentReplyEntity> {

	void replyCount(@Param("comId")Integer comId);
	
}
