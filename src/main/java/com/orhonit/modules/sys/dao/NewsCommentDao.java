package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.entity.NewsCommentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 新闻评论表
 * 
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-15 09:58:02
 */
@Mapper
public interface NewsCommentDao extends BaseMapper<NewsCommentEntity> {

	List<NewsCommentEntity> getNewsCommentByPage(@Param("newId")Integer newId, @Param("beginLimit")int beginLimit, @Param("limit")int limit);

	List<NewsCommentEntity> personalcomment(@Param("userId")Long userId, @Param("beginLimit")int beginLimit, @Param("limit")int limit);
	
}
