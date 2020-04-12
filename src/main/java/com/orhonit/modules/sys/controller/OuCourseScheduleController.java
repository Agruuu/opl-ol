package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.sys.entity.OuCourseScheduleEntity;
import com.orhonit.modules.sys.service.OuCourseScheduleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 课程时间表
 */
@RestController
@RequestMapping("generator/oucourseschedule")
public class OuCourseScheduleController {
    @Autowired
    private OuCourseScheduleService ouCourseScheduleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:oucourseschedule:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ouCourseScheduleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{ctId}")
    @RequiresPermissions("generator:oucourseschedule:info")
    public R info(@PathVariable("ctId") Integer ctId){
			OuCourseScheduleEntity ouCourseSchedule = ouCourseScheduleService.selectById(ctId);

        return R.ok().put("ouCourseSchedule", ouCourseSchedule);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:oucourseschedule:save")
    public R save(@RequestBody OuCourseScheduleEntity ouCourseSchedule){
			ouCourseScheduleService.insert(ouCourseSchedule);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:oucourseschedule:update")
    public R update(@RequestBody OuCourseScheduleEntity ouCourseSchedule){
			ouCourseScheduleService.updateById(ouCourseSchedule);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//    @RequiresPermissions("generator:oucourseschedule:delete")
    public R delete(@RequestBody Integer[] ctIds){
			ouCourseScheduleService.deleteBatchIds(Arrays.asList(ctIds));

        return R.ok();
    }

}
