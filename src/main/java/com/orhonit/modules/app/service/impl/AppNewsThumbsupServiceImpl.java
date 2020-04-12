package com.orhonit.modules.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;

import com.orhonit.modules.app.dao.AppNewsThumbsupDao;
import com.orhonit.modules.app.entity.AppNewsThumbsupEntity;
import com.orhonit.modules.app.service.AppNewsThumbsupService;


@Service("newsThumbsupService")
public class AppNewsThumbsupServiceImpl extends ServiceImpl<AppNewsThumbsupDao, AppNewsThumbsupEntity> implements AppNewsThumbsupService {
	
	@Autowired
	private AppNewsThumbsupDao appNewsThumbsupDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AppNewsThumbsupEntity> page = this.selectPage(
                new Query<AppNewsThumbsupEntity>(params).getPage(),
                new EntityWrapper<AppNewsThumbsupEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public void updateNewZan(Integer newId) {
		// TODO Auto-generated method stub
		appNewsThumbsupDao.updateNewZan(newId);
	}

}
