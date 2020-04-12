package com.orhonit.modules.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;

import com.orhonit.modules.app.dao.AppNewsCommentReplyDao;
import com.orhonit.modules.app.entity.AppNewsCommentReplyEntity;
import com.orhonit.modules.app.service.AppNewsCommentReplyService;

@Service("AppNewsCommentReplyService")
public class AppNewsCommentReplyServiceImpl extends ServiceImpl<AppNewsCommentReplyDao, AppNewsCommentReplyEntity> implements AppNewsCommentReplyService {
	
	@Autowired
	private AppNewsCommentReplyDao appNewsCommentReplyDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AppNewsCommentReplyEntity> page = this.selectPage(
                new Query<AppNewsCommentReplyEntity>(params).getPage(),
                new EntityWrapper<AppNewsCommentReplyEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public void replyCount(Integer comId) {
		// TODO Auto-generated method stub
		appNewsCommentReplyDao.replyCount(comId);
	}


}
