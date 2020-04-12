package com.orhonit.modules.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.modules.app.dao.AppNewsLbtDao;
import com.orhonit.modules.app.service.AppNewsLbtService;
import com.orhonit.modules.sys.entity.NewsLbtEntity;

@Service("AppNewsLbtService")
public class AppNewsLbtServiceImpl extends ServiceImpl<AppNewsLbtDao, NewsLbtEntity> implements AppNewsLbtService{
	
	@Autowired
	private AppNewsLbtDao appNewsLbtDao;

	@Override
	public List<NewsLbtEntity> getALLlist() {
		// TODO Auto-generated method stub
		return appNewsLbtDao.getALLlist();
	}
}
