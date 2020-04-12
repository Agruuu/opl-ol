package com.orhonit.modules.app.controller;

import java.util.Arrays;
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
import com.orhonit.modules.app.service.AppNewsCommentsService;
import com.orhonit.modules.sys.entity.NewsCommentEntity;
import com.orhonit.modules.sys.service.NewsCommentService;
/**
 * app评论控制类
 * @author ds2307813
 *
 */
@RestController
@RequestMapping("/app")
public class AppNewsCommentController {
	
	 	@Autowired
	    private AppNewsCommentsService appNewsCommentsService;
	 	
	    @Autowired
	    private NewsCommentService newsCommentService;
	 	
	    /**
	     * 单条评论和他的评论回复
	     */
	 	@Login
	    @GetMapping("newcomment/info")
	    //@RequiresPermissions("sys:newscomment:list")
	    public R newComAndReply(@RequestParam Map<String, Object> params){
	    	if(StringUtils.isNotBlank(params.get("commentId").toString())) {
	    		
	    		return R.ok().put("newComAndReply", appNewsCommentsService.newComAndReply(params));     
	    	}
	    	return R.parameterIsNul();
	    }
	 	
	    /**
	     * 保存
	     */
	 	@Login
	    @PostMapping("newcomment/save")
	    //@RequiresPermissions("sys:newscomment:save")
	    public R save(@RequestBody NewsCommentEntity newsComment){
				newsCommentService.insert(newsComment);

	        return R.ok();
	    }

	    /**
	     * 评论列表
	     */
	 	@Login
	    @GetMapping("newcomment/list")
	    //@RequiresPermissions("sys:newscomment:list")
	    public R list(@RequestParam Map<String, Object> params){
	    	if(StringUtils.isNotBlank(params.get("newId").toString())) {
	    		PageUtils page = newsCommentService.queryPage(params);
	    		return R.ok().put("page", page);     
	    	}
	    	return R.error();
	    }
	 	
	    /**
	     * 个人评论列表
	     */
	 	@Login
	    @GetMapping("newcomment/personalcomment")
	    //@RequiresPermissions("sys:newscomment:list")
	    public R personalcomment(@RequestParam Map<String, Object> params,@RequestAttribute Long userId){
	    	if(userId!=null) {
	    		PageUtils page = newsCommentService.personalcomment(params,userId);
	    		return R.ok().put("page", page);     
	    	}
	    	return R.error();
	    }
	 	

	    /**
	     * 修改
	     */
	 	@Login
	    @PostMapping("newcomment/update/{commentId}")
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
	 	@Login
	    @RequestMapping("newcomment/delete")
	    //@RequiresPermissions("sys:newscomment:delete")
	    public R delete(@RequestBody Integer[] commentIds){
				newsCommentService.deleteBatchIds(Arrays.asList(commentIds));

	        return R.ok();
	    }
}
