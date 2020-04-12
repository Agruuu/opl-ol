package com.orhonit.modules.sys.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.R;
import com.orhonit.modules.sys.entity.WelcomeNewpEntity;
import com.orhonit.modules.sys.service.WelcomeNewpService;



/**
 * 欢迎新成员表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-28 16:30:54
 */
@RestController
@RequestMapping("sys/welcomenewp")
public class WelcomeNewpController {
    @Autowired
    private WelcomeNewpService welcomeNewpService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    //@RequiresPermissions("sys:welcomenewp:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = welcomeNewpService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    @RequestMapping("/info/{newpId}")
    //@RequiresPermissions("sys:welcomenewp:info")
    public R info(@PathVariable("newpId") Integer newpId){
			WelcomeNewpEntity welcomeNewp = welcomeNewpService.selectById(newpId);

        return R.ok().put("welcomeNewp", welcomeNewp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:welcomenewp:save")
    public R save(@RequestBody WelcomeNewpEntity welcomeNewp){
			welcomeNewpService.insert(welcomeNewp);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:welcomenewp:update")
    public R update(@RequestBody WelcomeNewpEntity welcomeNewp){
			welcomeNewpService.updateById(welcomeNewp);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:welcomenewp:delete")
    public R delete(@RequestBody Integer[] newpIds){
			welcomeNewpService.deleteBatchIds(Arrays.asList(newpIds));

        return R.ok();
    }

}
