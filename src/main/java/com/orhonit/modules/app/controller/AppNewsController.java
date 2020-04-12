package com.orhonit.modules.app.controller;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.annotation.LoginUser;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.app.service.AppNewsService;
import com.orhonit.modules.app.vo.AppNewsVo;
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
@RequestMapping("/app")
public class AppNewsController {
    @Autowired
    private AppNewsService appNewsService;
    
    @Autowired
    private NewsService newsService;
        
    /**
     * 分页查询全部新闻
     */
    @RequestMapping("new/list")
    //@RequiresPermissions("sys:news:list")
    public R list(@RequestParam Map<String, Object> params){
    	if(params.get("newModel")!=null&&StringUtils.isNotBlank(params.get("newModel").toString())) {
            PageUtils page = appNewsService.queryPage(params);
            return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }
    
    /**
     * 分页查询个人作品
     */
    @Login
    @RequestMapping("new/myWorks")
    //@RequiresPermissions("sys:news:list")
    public R myWorks(@RequestParam Map<String, Object> params,@RequestAttribute Long userId){
    	if(userId!=null&&params.get("newModel")!=null&&StringUtils.isNotBlank(params.get("newModel").toString())) {
            PageUtils page = appNewsService.myWorks(params,userId);
            return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }
    
    /**
     * 分页查询交流互动
     */
    @Login
    @RequestMapping("new/interaction")
    //@RequiresPermissions("sys:news:list")
    public R interaction(@RequestParam Map<String, Object> params,@LoginUser AppUserEntity user){
    	if(user.getUserDept()!=null) {
            PageUtils page = appNewsService.interaction(params,user.getUserDept());
            return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }
    
    /**
     * 分页查询记忆与思念
     */
    @Login
    @RequestMapping("new/menandmiss")
    //@RequiresPermissions("sys:news:list")
    public R menAndMiss(@RequestParam Map<String, Object> params,@LoginUser AppUserEntity user){
    	int modelType=0;
    	try {
    		modelType = Integer.parseInt(params.get("newModel").toString());
		} catch (Exception e) {
			return R.parameterIsNul();
		}  	
    	if(user.getUserDept()!=null) {
            PageUtils page = appNewsService.menAndMiss(params,user.getUserDept(),modelType);
            return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }
    
    /**
     * 分页查询置顶新闻
     */
    @RequestMapping("new/getTopNew")
    //@RequiresPermissions("sys:news:list")
    public R getTopNew(@RequestParam Map<String, Object> params){
    	if(params.get("newTopNew")!=null&&StringUtils.isNotBlank(params.get("newTopNew").toString())){
            PageUtils page = appNewsService.getTopNew(params);
            return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }
    
    /**
     * 全部新闻分页模糊查询
     */
    @RequestMapping("new/getAllNew")
    //@RequiresPermissions("sys:news:list")
    public R getAllNewByLike(@RequestParam Map<String, Object> params){
    	if(params.get("newTitle")!=null&&StringUtils.isNotBlank(params.get("newTitle").toString())){
            PageUtils page = appNewsService.getAllNewByLike(params);
            return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }
    
	/**
	 * 单条新闻和他的评论
	 */
    //@Login
    @GetMapping("new/info")
    //@RequiresPermissions("sys:news:info")
    public R info(@RequestParam Map<String, Object> param){
    	if(StringUtils.isNotBlank(param.get("newId").toString())) {
    		
        	AppNewsVo news = appNewsService.selectNewAndComment(param);
        	int isZan = appNewsService.selectIsZan(param);
        	      	
            return R.ok().put("news", news).put("isZan", isZan);
    	}
    	return R.parameterIsNul();
    }
    
	/**
	 * 用户加自己作品
	 */
    @Login
    @PostMapping("new/appSave")
    public R appSave(@RequestBody NewsEntity news,@LoginUser AppUserEntity user){
    	//System.out.println(new Date());
    	if(user.getUserId()!=null&&user.getUserDept()!=null) {
    		news.setNewCreateTime(new Date());
    		news.setUserId(user.getUserId());
    		news.setNewDeptId(user.getUserDept());
    		news.setNewOrg(user.getUserOrg());
    		newsService.insert(news);
    		return R.ok();
    	}
    	    return R.parameterIsNul();
    }
    
    /**
     * 修改
     */
    @Login
    @PostMapping("new/update")
   //@RequiresPermissions("sys:news:update")
    public R update(@RequestBody NewsEntity news){
			newsService.updateById(news);

        return R.ok();
    }
    
    /**
     * 删除
     */
    @Login
    @RequestMapping("new/appDelete")
    //@RequiresPermissions("sys:news:delete")
    public R appDelete(@RequestParam Integer newId){
			newsService.deleteByNewId(newId);
			
        return R.ok();
    }
    
    /**
     * 新闻置顶
     */
    @Login
    @RequestMapping("new/toTop/{newTopNew}/{newId}")
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
