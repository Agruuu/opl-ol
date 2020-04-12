package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.entity.NewsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-11 09:10:07
 */
@Mapper
public interface NewsDao extends BaseMapper<NewsEntity> {

	List<NewsEntity> getAllNews();

	void NewtoTop(@Param("newTopNew")Integer newTopNew, @Param("newId")Integer newId);
	//删除新闻
	void deleteNew(@Param("newId")Integer newId);
	//删除新闻评论和评论回复
	void deleteNewCommentAndReply(@Param("newId")Integer newId);
	
}
