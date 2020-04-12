package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.modules.sys.entity.SysDictEntity;
import com.orhonit.modules.sys.service.SysDictService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;



/**
 * 字典表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-28 11:47:36
 */
@RestController
@RequestMapping("sys/sysdict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;
    
    /**
     * 获取民族，根据录入录入顺序查询
     * @return
     */
    @RequestMapping("/getraceList")
    public R raceList(){
    	return R.ok().put("raceList", sysDictService.getRaceList());
    }
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:sysdict:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysDictService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{dictId}")
    @RequiresPermissions("sys:sysdict:info")
    public R info(@PathVariable("dictId") Long dictId){
			SysDictEntity sysDict = sysDictService.selectById(dictId);

        return R.ok().put("sysDict", sysDict);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:sysdict:save")
    public R save(@RequestBody SysDictEntity sysDict){
			sysDictService.insert(sysDict);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:sysdict:update")
    public R update(@RequestBody SysDictEntity sysDict){
			sysDictService.updateById(sysDict);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:sysdict:delete")
    public R delete(@RequestBody Long[] dictIds){
			sysDictService.deleteBatchIds(Arrays.asList(dictIds));

        return R.ok();
    }

}
