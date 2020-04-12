package com.orhonit.modules.app.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.app.vo.AppNewsListVo;
import com.orhonit.modules.app.vo.AppNewsVo;

@Mapper
public interface AppNewsDao extends BaseMapper<AppNewsVo> {

	AppNewsVo selectNewAndComment(@Param("newId")Integer newId, @Param("beginLimit")int beginLimit, @Param("limit")int limit);

	List<AppNewsListVo> getAppNewsList(@Param("newModel")Integer newModel, @Param("beginLimit")int beginLimit, @Param("limit")int limit);

	List<AppNewsListVo> getTopNew(@Param("newTopNew")Integer newTopNew,@Param("newSupperModel")Integer newSupperModel,@Param("beginLimit")int beginLimit, @Param("limit")int limit);
	
	List<AppNewsListVo> getTopNewTwo(@Param("newTopNew")Integer newTopNew,@Param("beginLimit")int beginLimit, @Param("limit")int limit);
	//根据用户id查询新闻
	List<AppNewsListVo> myWorks(@Param("newModel")Integer newModel,@Param("userId")Long userId,@Param("beginLimit")int beginLimit, @Param("limit")int limit);
	//点击量
	void updatenewClick(@Param("newId")Integer newId);
	//查询是否点赞
	int selectIsZan(@Param("userId")Long userId,@Param("newId")int newId);
	//模糊查询所有新闻
	List<AppNewsListVo> getAllNewByLike(@Param("newTitle")String newTitle,@Param("beginLimit")int beginLimit, @Param("limit")int limit);
	//根据支部id查询新闻
	List<AppNewsListVo> interaction(@Param("userDept")Integer userDept,@Param("beginLimit")int beginLimit, @Param("limit")int limit);

	List<AppNewsListVo> menAndMiss(@Param("userDept")Integer userDept,@Param("newModel")int newModel,@Param("beginLimit")int beginLimit, @Param("limit")int limit);



	
}
