package com.orhonit.modules.sys.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dao.NewsCommentDao;
import com.orhonit.modules.sys.entity.NewsCommentEntity;
import com.orhonit.modules.sys.service.NewsCommentService;

@Service("newsCommentService")
public class NewsCommentServiceImpl extends ServiceImpl<NewsCommentDao, NewsCommentEntity> implements NewsCommentService {
	
	@Autowired
	private NewsCommentDao newsCommentDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	Integer newId = Integer.parseInt((String) params.get("newId"));
    	int currPage = 1;
    	int limit = 10;
    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
        Page<NewsCommentEntity> page = new Page<>(currPage, limit);
        int beginLimit = (currPage-1)*limit;
        page.setRecords(newsCommentDao.getNewsCommentByPage(newId,beginLimit,limit));
        page.setTotal(this.selectCount(new EntityWrapper<NewsCommentEntity>().where("new_id="+newId)));
        return new PageUtils(page);
    }

	@Override
	public PageUtils personalcomment(Map<String, Object> params, Long userId) {
    	int currPage = 1;
    	int limit = 10;
    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
        Page<NewsCommentEntity> page = new Page<>(currPage, limit);
        int beginLimit = (currPage-1)*limit;
        page.setRecords(newsCommentDao.personalcomment(userId,beginLimit,limit));
        //page.setTotal(this.selectCount(new EntityWrapper<NewsCommentEntity>().where("new_id="+newId)));
        return new PageUtils(page);
	}
}
