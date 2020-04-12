package com.orhonit.modules.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.entity.NewsCollcetionEntity;
import com.orhonit.modules.app.service.NewsCollcetionService;



/**
 * 新闻收藏表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-04-02 14:45:15
 */
@RestController
@RequestMapping("/app/newscollcetion")
public class NewsCollcetionController {
    @Autowired
    private NewsCollcetionService newsCollcetionService;

    /**
     * 列表
     */
    @Login
    @RequestMapping("list")
    public R list(@RequestParam Map<String, Object> params,@RequestAttribute("userId") Long userId){
    	
        PageUtils page = newsCollcetionService.queryPage(params,userId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("info/{collcetionId}")
    public R info(@PathVariable("collcetionId") Integer collcetionId){
			NewsCollcetionEntity newsCollcetion = newsCollcetionService.selectById(collcetionId);

        return R.ok().put("newsCollcetion", newsCollcetion);
    }

    /**
     * 保存
     */
    @Login
    @RequestMapping("save")
    public R save(@RequestBody NewsCollcetionEntity newsCollcetion,@RequestAttribute("userId") Long userId){
    	if(newsCollcetion.getNewId()==null||newsCollcetion.getNewTitle()==null||userId==null) {
    		return R.error(-1,"收藏失败~");
    	}
    		newsCollcetion.setUserId(userId);
    		newsCollcetion.setCrtTime(new Date().getTime());
			newsCollcetionService.insert(newsCollcetion);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("update")
    public R update(@RequestBody NewsCollcetionEntity newsCollcetion){
			newsCollcetionService.updateById(newsCollcetion);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("delete")
    public R delete(@RequestBody Integer[] collcetionIds){
			newsCollcetionService.deleteBatchIds(Arrays.asList(collcetionIds));

        return R.ok();
    }
    
    /**
     * APP用戶端-新闻收藏-根据收藏表id删除
     */
    @RequestMapping("deleteByCollcetionId/{collcetionId}")
    public R deleteByCollcetionId(@PathVariable("collcetionId") Integer collcetionId){
			newsCollcetionService.deleteById(collcetionId);
        return R.ok();
    }

}
