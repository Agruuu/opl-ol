package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.sys.entity.NewsCommentEntity;
import com.orhonit.modules.sys.service.NewsCommentService;



/**
 * 新闻评论表
 *
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-15 09:58:02
 */
@RestController
@RequestMapping("sys/newscomment")
public class NewsCommentController {
    @Autowired
    private NewsCommentService newsCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:newscomment:list")
    public R list(@RequestParam Map<String, Object> params){
    	if(params.get("newId")!=null) {
    		PageUtils page = newsCommentService.queryPage(params);
    		return R.ok().put("page", page);     
    	}
    	return R.error();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{commentId}")
    //@RequiresPermissions("sys:newscomment:info")
    public R info(@PathVariable("commentId") Integer commentId){
			NewsCommentEntity newsComment = newsCommentService.selectById(commentId);

        return R.ok().put("newsComment", newsComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:newscomment:save")
    public R save(@RequestBody NewsCommentEntity newsComment){
			newsCommentService.insert(newsComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update/{commentId}")
    //@RequiresPermissions("sys:newscomment:update")
    public R update(@PathVariable Integer commentId){
    	if(commentId!=null) {
        	NewsCommentEntity newsComment = new NewsCommentEntity();
        	newsComment.setCommentId(commentId);
        	newsComment.setCommentContent("富强，民主，文明，和谐，自由，平等，公正，法治，爱国，敬业，诚信，友善。");
    			newsCommentService.updateById(newsComment);     
    			return R.ok();
    	}

        return R.parameterIsNul();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:newscomment:delete")
    public R delete(@RequestBody Integer[] commentIds){
			newsCommentService.deleteBatchIds(Arrays.asList(commentIds));

        return R.ok();
    }

}
