package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.sys.entity.OuSignupEntity;
import com.orhonit.modules.sys.service.OuSignupService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 课程报名
 */
@RestController
@RequestMapping("generator/ousignup")
public class OuSignupController {
    @Autowired
    private OuSignupService ouSignupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:ousignup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = ouSignupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{signId}")
    @RequiresPermissions("generator:ousignup:info")
    public R info(@PathVariable("signId") Integer signId){
			OuSignupEntity ouSignup = ouSignupService.selectById(signId);

        return R.ok().put("ouSignup", ouSignup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:ousignup:save")
    public R save(@RequestBody OuSignupEntity ouSignup){
			ouSignupService.insert(ouSignup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:ousignup:update")
    public R update(@RequestBody OuSignupEntity ouSignup){
			ouSignupService.updateById(ouSignup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:ousignup:delete")
    public R delete(@RequestBody Integer[] signIds){
			ouSignupService.deleteBatchIds(Arrays.asList(signIds));

        return R.ok();
    }

}
