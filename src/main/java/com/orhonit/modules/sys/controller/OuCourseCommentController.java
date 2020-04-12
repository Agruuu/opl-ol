package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.sys.entity.OuCourseCommentEntity;
import com.orhonit.modules.sys.service.OuCourseCommentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 课程评价
 */
@RestController
@RequestMapping("/courseComment")
public class OuCourseCommentController {
    @Autowired
    private OuCourseCommentService ouCourseCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:oucoursecomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ouCourseCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{commId}")
    @RequiresPermissions("generator:oucoursecomment:info")
    public R info(@PathVariable("commId") Integer commId){
			OuCourseCommentEntity ouCourseComment = ouCourseCommentService.selectById(commId);

        return R.ok().put("ouCourseComment", ouCourseComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:oucoursecomment:save")
    public R save(@RequestBody OuCourseCommentEntity ouCourseComment){
			ouCourseCommentService.insert(ouCourseComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:oucoursecomment:update")
    public R update(@RequestBody OuCourseCommentEntity ouCourseComment){
			ouCourseCommentService.updateById(ouCourseComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:oucoursecomment:delete")
    public R delete(@RequestBody Integer[] commIds){
			ouCourseCommentService.deleteBatchIds(Arrays.asList(commIds));

        return R.ok();
    }

}
