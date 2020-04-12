package com.orhonit.modules.sys.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.NewsDao;
import com.orhonit.modules.sys.entity.NewsEntity;
import com.orhonit.modules.sys.service.NewsService;


@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {
	
	@Autowired
	private NewsDao newsDao; 
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
		String newTitle = params.get("newTitle").toString();
		Integer newModel = Integer.parseInt((String) params.get("newModel"));
        Page<NewsEntity> page = this.selectPage(
                new Query<NewsEntity>(params).getPage(),
                new EntityWrapper<NewsEntity>().like(StringUtils.isNotBlank(newTitle), "new_title", newTitle).and("new_model="+newModel).orderBy("new_top_new DESC,new_id DESC")
        );
        page.setTotal(this.selectCount(new EntityWrapper<NewsEntity>().like(StringUtils.isNotBlank(newTitle), "new_title", newTitle).and("new_model="+newModel)));
        return new PageUtils(page);
    }

	@Override
	public void NewtoTop(Integer newTopNew, Integer newId) {
		// TODO Auto-generated method stub
		newsDao.NewtoTop(newTopNew,newId);
	}

	@Override
	public void deleteByNewId(Integer newId) {
		// TODO Auto-generated method stub
		newsDao.deleteNew(newId);
		newsDao.deleteNewCommentAndReply(newId);
	}
	
	/**
	 * 每天2点定时把数据放入数据库
	 */

public static void showDayTime() {
            Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
 
		calendar.set(year, month, day, 2,00, 00);//设置要执行的日期时间
 
		Date defaultdate = calendar.getTime();
 
		Timer dTimer = new Timer();
		dTimer.schedule(new TimerTask() {
		@Override
		public void run() {
			//获取数据开始
			
		     System.out.println("每日任务已经执行");
		}
		}, defaultdate , 24* 60* 60 * 1000);//24* 60* 60 * 1000
	};

}
