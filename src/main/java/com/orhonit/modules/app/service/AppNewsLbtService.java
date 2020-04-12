package com.orhonit.modules.app.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.modules.sys.entity.NewsLbtEntity;

public interface AppNewsLbtService extends IService<NewsLbtEntity>{

	List<NewsLbtEntity> getALLlist();
	
	
}
