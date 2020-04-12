package com.orhonit.modules.app.controller;

import java.util.Arrays;
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
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.app.service.AppUserService;

/**
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-27 10:38:42
 */
@RestController
@RequestMapping("/app/appuser")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    /**
     * 列表
     */
    @RequestMapping("list")
    //@RequiresPermissions("app:appuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = appUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("info/{userId}")
    //@RequiresPermissions("app:appuser:info")
    public R info(@PathVariable("userId") Integer userId){
			AppUserEntity appUser = appUserService.selectById(userId);
			appUser.setPassword("");
        return R.ok().put("appUser", appUser);
    }

    /**
     * 保存
     */
    @RequestMapping("save")
    //@RequiresPermissions("app:appuser:save")
    public R save(@RequestBody AppUserEntity appUser){
			appUserService.insert(appUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @Login
    @RequestMapping("update")
    //@RequiresPermissions("app:appuser:update")
    public R update(@RequestBody AppUserEntity appUser,@RequestAttribute("userId") Long userId){
    	AppUserEntity appUserEntity = new AppUserEntity();
    		if(userId!=null) {
    			appUserEntity.setUserId(userId);
    			appUserEntity.setUserNickname(appUser.getUserNickname());
    			appUserEntity.setUserHeadPicture(appUser.getUserHeadPicture());
    			appUserService.updateById(appUserEntity);

    	        return R.ok();
    		}
    		return R.parameterIsNul();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("app:appuser:delete")
    public R delete(@RequestBody Integer[] userIds){
			appUserService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }

}
