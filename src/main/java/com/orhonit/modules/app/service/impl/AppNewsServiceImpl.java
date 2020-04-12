package com.orhonit.modules.app.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.app.dao.AppNewsDao;
import com.orhonit.modules.app.service.AppNewsService;
import com.orhonit.modules.app.vo.AppNewsListVo;
import com.orhonit.modules.app.vo.AppNewsVo;

@Service("appNewsService")
public class AppNewsServiceImpl extends ServiceImpl<AppNewsDao,AppNewsVo> implements AppNewsService{
	
	@Autowired
	private AppNewsDao appNewsDao;
	/**
	 * 单条新闻和他的评论
	 */
	@Override
	public AppNewsVo selectNewAndComment(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Integer newId = Integer.parseInt(params.get("newId").toString());
		int currPage = 1;
    	int limit = 10;

    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
         int beginLimit = (currPage-1)*limit;
         appNewsDao.updatenewClick(newId);
		return appNewsDao.selectNewAndComment(newId,beginLimit,limit);
	}
	
	/**
	 * 分页查询全部新闻
	 */
	@Override
	public PageUtils queryPage(Map<String, Object> params) {	
		Integer newModel = Integer.parseInt(params.get("newModel").toString());
    	int currPage = 1;
    	int limit = 10;

    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
        Page<AppNewsListVo> page = new Page<>(currPage, limit);
        int beginLimit = (currPage-1)*limit;
        List<AppNewsListVo> newsComEntityList = appNewsDao.getAppNewsList(newModel,beginLimit,limit);
//        Collections.sort(newsComEntityList,new Comparator<AppNewsListVo>(){
//			@Override
//			public int compare(AppNewsListVo o1, AppNewsListVo o2) {
//				int diff = o1.getNewTopNew()-o2.getNewTopNew();
//				if(diff>0) {
//					return 1;
//				}else if (diff<0){
//					return -1;
//				}
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
        page.setRecords(newsComEntityList);
        //page.setTotal(this.selectCount(new EntityWrapper<AppNewsCommentVo>().where("new_id="+newId)));
        return new PageUtils(page);
	}
	
	/**
	 * 分页查询个人作品
	 */
	@Override
	public PageUtils myWorks(Map<String, Object> params,long userId) {
		//Long userId = Long.parseLong(params.get("userId").toString());
		Integer newModel = Integer.parseInt(params.get("newModel").toString());
    	int currPage = 1;
    	int limit = 10;

    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
        Page<AppNewsListVo> page = new Page<>(currPage, limit);
        int beginLimit = (currPage-1)*limit;
        List<AppNewsListVo> newsComEntityList = appNewsDao.myWorks(newModel,userId,beginLimit,limit);
        page.setRecords(newsComEntityList);
        return new PageUtils(page);
	}
	
	/**
	 * 分页查询交流互动
	 */
	@Override
	public PageUtils interaction(Map<String, Object> params, Integer userDept) {
    	int currPage = 1;
    	int limit = 10;

    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
        Page<AppNewsListVo> page = new Page<>(currPage, limit);
        int beginLimit = (currPage-1)*limit;
        List<AppNewsListVo> newsComEntityList = appNewsDao.interaction(userDept,beginLimit,limit);
        page.setRecords(newsComEntityList);
        return new PageUtils(page);
	}

	@Override
	public PageUtils menAndMiss(Map<String, Object> params, Integer userDept,int newModel) {
    	int currPage = 1;
    	int limit = 10;
    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
        Page<AppNewsListVo> page = new Page<>(currPage, limit);
        int beginLimit = (currPage-1)*limit;
        List<AppNewsListVo> newsComEntityList = appNewsDao.menAndMiss(userDept,newModel,beginLimit,limit);
        page.setRecords(newsComEntityList);
        return new PageUtils(page);
	}
	
	/**
	 * 分页查询置顶新闻
	 */
	@Override
	public PageUtils getTopNew(Map<String, Object> params) {
		Integer newTopNew = Integer.parseInt(params.get("newTopNew").toString());
		
    	int currPage = 1;
    	int limit = 10;

    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
        Page<AppNewsListVo> page = new Page<>(currPage, limit);
        int beginLimit = (currPage-1)*limit;
        if(params.get("newSupperModel")!=null){
        	Integer newSupperModel = Integer.parseInt(params.get("newSupperModel").toString());
        	  List<AppNewsListVo> newsComEntityList = appNewsDao.getTopNew(newTopNew,newSupperModel,beginLimit,limit);
        	  page.setRecords(newsComEntityList);
        	  return new PageUtils(page);
        }
        List<AppNewsListVo> newsComEntityList = appNewsDao.getTopNewTwo(newTopNew,beginLimit,limit);
//        Collections.sort(newsComEntityList,new Comparator<AppNewsListVo>(){
//			@Override
//			public int compare(AppNewsListVo o1, AppNewsListVo o2) {
//				int diff = o1.getNewTopNew()-o2.getNewTopNew();
//				if(diff>0) {
//					return 1;
//				}else if (diff<0){
//					return -1;
//				}
//				// TODO Auto-generated method stub
//				return 0;
//			}
//		});
        page.setRecords(newsComEntityList);
        //page.setTotal(this.selectCount(new EntityWrapper<AppNewsCommentVo>().where("new_id="+newId)));
        return new PageUtils(page);
	}
	
	/**
	 * 是否点赞
	 */
	@Override
	public int selectIsZan(Map<String, Object> param) {
		int isZan = 0;
		if(param.get("userId")!=null&&StringUtils.isNotBlank(param.get("userId").toString())) {
			Long userId = Long.parseLong(param.get("userId").toString());
			int newId = Integer.parseInt(param.get("newId").toString());
			isZan  = appNewsDao.selectIsZan(userId,newId);
		}
		// TODO Auto-generated method stub
		return isZan;
	}
	@Override
	public PageUtils getAllNewByLike(Map<String, Object> params) {
    	int currPage = 1;
    	int limit = 10;

    	 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
        Page<AppNewsListVo> page = new Page<>(currPage, limit);
        int beginLimit = (currPage-1)*limit;
        List<AppNewsListVo> newsComEntityList = appNewsDao.getAllNewByLike(params.get("newTitle").toString(),beginLimit,limit);
        page.setRecords(newsComEntityList);
        return new PageUtils(page);
	}


}
