package com.orhonit.modules.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.app.vo.AppNewsCommentVo;

@Mapper
public interface AppNewsCommentDao extends BaseMapper<AppNewsCommentVo>{

	AppNewsCommentVo newComAndReply(@Param("commentId")Integer commentId, @Param("beginLimit")int beginLimit, @Param("limit")int limit);

}
