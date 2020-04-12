package com.orhonit.modules.sys.controller;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.JiguangPushUtil;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.vo.AppTuiSongVo;
import com.orhonit.modules.sys.dao.UserPhoneNumCardDao;
import com.orhonit.modules.sys.entity.NewsEntity;
import com.orhonit.modules.sys.service.NewsService;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-11 09:10:07
 */
@RestController
@RequestMapping("sys/news")
public class NewsController extends AbstractController{
    @Autowired
    private NewsService newsService;
    
    @Autowired
    private UserPhoneNumCardDao userPhoneNumCardDao;    
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:news:list")
    public R list(@RequestParam Map<String, Object> params){
    	if(StringUtils.isNotBlank(params.get("newModel").toString())) {
    		 PageUtils page = newsService.queryPage(params);
    	        return R.ok().put("page", page);
    	}
       return R.parameterIsNul();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{newId}")
    //@RequiresPermissions("sys:news:info")
    public R info(@PathVariable("newId") Integer newId){
			NewsEntity news = newsService.selectById(newId);

        return R.ok().put("news", news);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:news:save")
    public R save(@RequestBody NewsEntity news){
    	//System.out.println(new Date());、
    if(news.getUserId()!=null) {
    	news.setNewCreateTime(new Date());
		newsService.insert(news);
		//如果新闻二级模块为记忆与思念(model_id=25)发送推送信息
		if(news.getNewModel()!=null&&news.getNewModel()==25) {
			AppTuiSongVo appTuiSongVo = new AppTuiSongVo();
			appTuiSongVo.setTypeCode(1);
			String newTitle=news.getNewTitle();
			JiguangPushUtil.jiguangPush(userPhoneNumCardDao.selectByDeptId(getUser().getUserDept()),newTitle,appTuiSongVo);
			return R.ok();
		}
		return R.ok();
    }
        return R.parameterIsNul();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
   //@RequiresPermissions("sys:news:update")
    public R update(@RequestBody NewsEntity news){
			newsService.updateById(news);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:news:delete")
    public R delete(@RequestParam Integer newId){
			newsService.deleteByNewId(newId);

        return R.ok();
    }
    
    /**
     * 新闻置顶
     */
    @RequestMapping("/toTop/{newTopNew}/{newId}")
    //@RequiresPermissions("sys:news:delete")
    public R NewtoTop(@PathVariable Integer newTopNew,@PathVariable Integer newId){
    	if(newTopNew!=null&&newId!=null) {
    		if(newTopNew==0) {
    			newTopNew=1;
    			newsService.NewtoTop(newTopNew,newId);
    		}else if(newTopNew==1) {
    			newTopNew=0;
    			newsService.NewtoTop(newTopNew,newId);
    		}
    		
    	}
			

        return R.ok();
    }

}
