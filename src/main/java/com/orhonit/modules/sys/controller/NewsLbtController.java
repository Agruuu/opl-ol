package com.orhonit.modules.sys.controller;

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
import com.orhonit.modules.sys.entity.NewsLbtEntity;
import com.orhonit.modules.sys.service.NewsLbtService;



/**
 * 
 *
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-14 11:09:47
 */
@RestController
@RequestMapping("sys/newslbt")
public class NewsLbtController {
    @Autowired
    private NewsLbtService newsLbtService;
    
    /**
     *后台维护列表
     */
    @GetMapping("/allList")
    //@RequiresPermissions("sys:newslbt:list")
    public R getALLlist(){
        List<NewsLbtEntity> list = newsLbtService.getALLlist();

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
    @RequestMapping("/info/{lbtId}")
    //@RequiresPermissions("sys:newslbt:info")
    public R info(@PathVariable("lbtId") Integer lbtId){
			NewsLbtEntity newsLbt = newsLbtService.selectById(lbtId);

        return R.ok().put("newsLbt", newsLbt);
    }

    /**
     * 保存
     */
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
    @RequestMapping("/update")
    //@RequiresPermissions("sys:newslbt:update")
    public R update(@RequestBody NewsLbtEntity newsLbt){
			newsLbtService.updateById(newsLbt);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:newslbt:delete")
    public R delete(@RequestBody Integer[] lbtIds){
			newsLbtService.deleteBatchIds(Arrays.asList(lbtIds));

        return R.ok();
    }

}
