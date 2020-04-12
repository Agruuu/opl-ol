package com.orhonit.modules.app.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.entity.AppNewsThumbsupEntity;
import com.orhonit.modules.app.service.AppNewsThumbsupService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;



/**
 * 
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-01-23 14:34:36
 */
@RestController
@RequestMapping("/app")
public class AppNewsThumbsupController {
    @Autowired
    private AppNewsThumbsupService newsThumbsupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("app:newsthumbsup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = newsThumbsupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{thumbsupId}")
    @RequiresPermissions("app:newsthumbsup:info")
    public R info(@PathVariable("thumbsupId") Integer thumbsupId){
			AppNewsThumbsupEntity newsThumbsup = newsThumbsupService.selectById(thumbsupId);

        return R.ok().put("newsThumbsup", newsThumbsup);
    }

    /**
     * 保存
     */
    @Login
    @RequestMapping("newsthumbsup/save")
    //@RequiresPermissions("app:newsthumbsup:save")
    public R save(@RequestBody AppNewsThumbsupEntity newsThumbsup){
    	if(newsThumbsup.getNewId()!=null&&newsThumbsup.getUserId()!=null) {
    		try {
    			newsThumbsupService.insert(newsThumbsup);
    			newsThumbsupService.updateNewZan(newsThumbsup.getNewId());
    	        return R.ok();
			} catch (Exception e) {
				// TODO: handle exception
				return R.error();
			}
    	}
    	return R.parameterIsNul();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:newsthumbsup:update")
    public R update(@RequestBody AppNewsThumbsupEntity newsThumbsup){
			newsThumbsupService.updateById(newsThumbsup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:newsthumbsup:delete")
    public R delete(@RequestBody Integer[] thumbsupIds){
			newsThumbsupService.deleteBatchIds(Arrays.asList(thumbsupIds));

        return R.ok();
    }

}
