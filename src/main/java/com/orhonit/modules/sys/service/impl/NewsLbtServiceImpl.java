package com.orhonit.modules.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.NewsLbtDao;
import com.orhonit.modules.sys.entity.NewsLbtEntity;
import com.orhonit.modules.sys.service.NewsLbtService;


@Service("newsLbtService")
public class NewsLbtServiceImpl extends ServiceImpl<NewsLbtDao, NewsLbtEntity> implements NewsLbtService {
	
	@Autowired
	private NewsLbtDao newsLbtDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NewsLbtEntity> page = this.selectPage(
                new Query<NewsLbtEntity>(params).getPage(),
                new EntityWrapper<NewsLbtEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<NewsLbtEntity> getALLlist() {
		// TODO Auto-generated method stub
		return newsLbtDao.getALLlist();
	}

}
