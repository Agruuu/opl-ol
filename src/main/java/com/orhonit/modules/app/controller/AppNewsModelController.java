package com.orhonit.modules.app.controller;

import java.util.Arrays;
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
import com.orhonit.modules.sys.entity.NewsModelEntity;
import com.orhonit.modules.sys.service.NewsModelService;
import com.orhonit.modules.sys.vo.NewsModelTreeVo;

@RestController
@RequestMapping("app/newsmodel")
public class AppNewsModelController {
	
	@Autowired
    private NewsModelService newsModelService;
    
    /**
     * 返回新闻树
     */
	@Login
    @GetMapping("/getNewsModelTree")
    public R getNewsModelTree() {
    	List<NewsModelTreeVo> getNewsModelTree = newsModelService.getNewsModelTree();
    	return R.ok().put("getNewsModelTree",getNewsModelTree);
    }

    /**
     * 列表
     */
	@Login
    @RequestMapping("/list")
    //@RequiresPermissions("sys:newsmodel:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = newsModelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
	@Login
    @RequestMapping("/info/{modelId}")
    //@RequiresPermissions("sys:newsmodel:info")
    public R info(@PathVariable("modelId") Integer modelId){
			NewsModelEntity newsModel = newsModelService.selectById(modelId);

        return R.ok().put("newsModel", newsModel);
    }

    /**
     * 保存
     */
	@Login
    @RequestMapping("/save")
    //@RequiresPermissions("sys:newsmodel:save")
    public R save(@RequestBody NewsModelEntity newsModel){
			newsModelService.insert(newsModel);

        return R.ok();
    }

    /**
     * 修改
     */
	@Login
    @RequestMapping("/update")
    //@RequiresPermissions("sys:newsmodel:update")
    public R update(@RequestBody NewsModelEntity newsModel){
			newsModelService.updateById(newsModel);

        return R.ok();
    }

    /**
     * 删除
     */
	@Login
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:newsmodel:delete")
    public R delete(@RequestBody Integer[] modelIds){
			newsModelService.deleteBatchIds(Arrays.asList(modelIds));

        return R.ok();
    }
}
