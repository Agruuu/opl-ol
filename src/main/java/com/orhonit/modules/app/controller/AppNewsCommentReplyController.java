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
import com.orhonit.modules.app.entity.AppNewsCommentReplyEntity;
import com.orhonit.modules.app.service.AppNewsCommentReplyService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;



/**
 * 回复评论表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-01-22 14:10:06
 */
@RestController
@RequestMapping("/app/newscommentreply")
public class AppNewsCommentReplyController {
    @Autowired
    private AppNewsCommentReplyService newsCommentReplyService;

    /**
     * 列表
     */
    @Login
    @RequestMapping("list")
    //@RequiresPermissions("app:newscommentreply:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = newsCommentReplyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{replyId}")
    @RequiresPermissions("app:newscommentreply:info")
    public R info(@PathVariable("replyId") Integer replyId){
			AppNewsCommentReplyEntity newsCommentReply = newsCommentReplyService.selectById(replyId);

        return R.ok().put("newsCommentReply", newsCommentReply);
    }

    /**
     * 保存
     */
    @Login
    @RequestMapping("save")
    //@RequiresPermissions("app:newscommentreply:save")
    public R save(@RequestBody AppNewsCommentReplyEntity newsCommentReply){
    	try {
			Long.parseLong(newsCommentReply.getUserId().toString()); 
		} catch (Exception e) {
			  return R.error(500, "请重新登录~~~");
		}
			newsCommentReplyService.insert(newsCommentReply);
			newsCommentReplyService.replyCount(newsCommentReply.getCommentId());
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("app:newscommentreply:update")
    public R update(@RequestBody AppNewsCommentReplyEntity newsCommentReply){
			newsCommentReplyService.updateById(newsCommentReply);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("app:newscommentreply:delete")
    public R delete(@RequestBody Integer[] replyIds){
			newsCommentReplyService.deleteBatchIds(Arrays.asList(replyIds));

        return R.ok();
    }

}
