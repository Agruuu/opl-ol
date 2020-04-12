package com.orhonit.modules.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.sys.service.WelcomeNewpService;
import com.orhonit.modules.sys.vo.WelcomeNewpVo;

@RestController
@RequestMapping("/app/WelcomeNewp")
public class AppWelcomeNewpController {
    @Autowired
    private WelcomeNewpService welcomeNewpService;
    /**
     * 列表
     */
    @Login
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,@RequestAttribute Long userId){
        PageUtils page = welcomeNewpService.queryPage(params,userId);

        return R.ok().put("page", page);
    }
    
    /**
     * 信息
     */
    @Login
    @RequestMapping("/info/{newpId}")
    //@RequiresPermissions("sys:welcomenewp:info")
    public R info(@PathVariable("newpId") Integer newpId){
    	WelcomeNewpVo welcomeNewp = welcomeNewpService.selectNewpById(newpId);

        return R.ok().put("welcomeNewp", welcomeNewp);
    }
}
