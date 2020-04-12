package com.orhonit.modules.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.service.AppNewsLbtService;
import com.orhonit.modules.sys.entity.NewsLbtEntity;
import com.orhonit.modules.sys.service.NewsLbtService;

@RestController
@RequestMapping("/app/newslbt")
public class AppNewsLbtController {

	    @Autowired
	    private AppNewsLbtService appNewsLbtService;
	    @Autowired
	    private NewsLbtService newsLbtService;
	    
	    /**
	     *轮播图展示
	     */
	    @GetMapping("/lbtListToApp")
	    //@RequiresPermissions("sys:newslbt:list")
	    public R getALLlist(){
		        List<NewsLbtEntity> list = appNewsLbtService.getALLlist();
		        return R.ok().put("list", list);
	    }
	    
	    /**
	     * 列表
	     */
	    @RequestMapping("/list")
	    //@RequiresPermissions("sys:newslbt:list")
	    public R list(@RequestParam Map<String, Object> params){
	        PageUtils page = newsLbtService.queryPage(params);

	        return R.ok().put("page", page);
	    }


	    /**
	     * 信息
	     */
	    @Login
	    @RequestMapping("/info/{lbtId}")
	    //@RequiresPermissions("sys:newslbt:info")
	    public R info(@PathVariable("lbtId") Integer lbtId){
				NewsLbtEntity newsLbt = newsLbtService.selectById(lbtId);

	        return R.ok().put("newsLbt", newsLbt);
	    }

	    /**
	     * 保存
	     */
	    @Login
	    @RequestMapping("/save")
	    //@RequiresPermissions("sys:newslbt:save")
	    public R save(@RequestBody NewsLbtEntity newsLbt){
	    	newsLbt.setCrtTime(new Date());
				newsLbtService.insert(newsLbt);

	        return R.ok();
	    }

	    /**
	     * 修改
	     */
	    @Login
	    @RequestMapping("/update")
	    //@RequiresPermissions("sys:newslbt:update")
	    public R update(@RequestBody NewsLbtEntity newsLbt){
				newsLbtService.updateById(newsLbt);

	        return R.ok();
	    }

	    /**
	     * 删除
	     */
	    @Login
	    @RequestMapping("/delete")
	    //@RequiresPermissions("sys:newslbt:delete")
	    public R delete(@RequestBody Integer[] lbtIds){
				newsLbtService.deleteBatchIds(Arrays.asList(lbtIds));

	        return R.ok();
	    }
}
