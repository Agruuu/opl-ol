package com.orhonit.modules.app.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.modules.app.dao.AppNewsCommentDao;
import com.orhonit.modules.app.service.AppNewsCommentsService;
import com.orhonit.modules.app.vo.AppNewsCommentVo;

@Service("appNewsCommentsService")
public class AppNewsCommentsServiceImpl  extends ServiceImpl<AppNewsCommentDao,AppNewsCommentVo> implements AppNewsCommentsService{
	
	@Autowired
	private AppNewsCommentDao appNewsCommentDao;
    /**
     * 单条评论和他的评论回复
     */
    @Override
    public AppNewsCommentVo newComAndReply(Map<String, Object> params) {
    	Integer commentId = Integer.parseInt((String) params.get("commentId"));
    	int currPage = 1;
    	int limit = 10;
    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
        int beginLimit = (currPage-1)*limit;
        AppNewsCommentVo appNewsCommentVo = appNewsCommentDao.newComAndReply(commentId,beginLimit,limit);
        
        //page.setTotal(this.selectCount(new EntityWrapper<AppNewsCommentVo>().where("new_id="+newId)));
        return appNewsCommentVo;
    }
}
