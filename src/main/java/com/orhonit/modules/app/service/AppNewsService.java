package com.orhonit.modules.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.app.vo.AppNewsVo;

public interface AppNewsService extends IService<AppNewsVo> {

	AppNewsVo selectNewAndComment(Map<String, Object> params);

	PageUtils queryPage(Map<String, Object> params);

	PageUtils getTopNew(Map<String, Object> params);
	
	PageUtils myWorks(Map<String, Object> params,long userId);

	int selectIsZan(Map<String, Object> param);

	PageUtils getAllNewByLike(Map<String, Object> params);

	PageUtils interaction(Map<String, Object> params, Integer userDept);

	PageUtils menAndMiss(Map<String, Object> params, Integer userDept,int newModel);
	
}
