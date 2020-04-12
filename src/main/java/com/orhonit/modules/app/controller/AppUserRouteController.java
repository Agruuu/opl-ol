package com.orhonit.modules.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.annotation.LoginUser;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.sys.entity.UserRouteEntity;
import com.orhonit.modules.sys.service.UserRouteService;

/**
 * 乘车路线表
 * @author 
 *
 */
@RestController
@RequestMapping("app/userroute")
public class AppUserRouteController {

	@Autowired
    private UserRouteService userRouteService;

    /**
     * 列表
     */
	@Login
    @RequestMapping("/list")
    //@RequiresPermissions("sys:userroute:list")
    public R list(@RequestParam Map<String, Object> params){
    	if(params.get("deptId")!=null){
    		 PageUtils page = userRouteService.queryPage(params);

    	        return R.ok().put("page", page);
    	}
    	 return R.parameterIsNul();
    }
    
    /**
     * 列表
     */
	@Login
    @RequestMapping("/routelist")
   //@RequiresPermissions("sys:userroute:list")
   public R routeList(@LoginUser AppUserEntity user){
    	if(user.getUserDept()!=null) {
    		int deptId = user.getUserDept();
    	   	List<UserRouteEntity> UserRouteEntityList = userRouteService.getRouteList(deptId);
   	        return R.ok().put("userRouteEntityList", UserRouteEntityList);
    	}
    	return R.parameterIsNul();
    }


    /**
     * 信息
     */
	@Login
    @RequestMapping("/info/{routeId}")
    //@RequiresPermissions("sys:userroute:info")
    public R info(@PathVariable("routeId") Integer routeId){
			UserRouteEntity userRoute = userRouteService.selectById(routeId);

        return R.ok().put("userRoute", userRoute);
    }
 
    /**
     * 保存
     */
	@Login
    @RequestMapping("/save")
    //@RequiresPermissions("sys:userroute:save")
    public R save(@RequestBody UserRouteEntity userRoute,@LoginUser AppUserEntity user){
    	if(user.getUserDept()!=null) {
        	userRoute.setCrtTime(new Date());
        	userRoute.setDeptId(user.getUserDept());
    	    userRouteService.insert(userRoute);
            return R.ok();
    	}
    	return R.parameterIsNul();
    }

    /**
     * 修改
     */
    @Login
    @RequestMapping("/update")
    //@RequiresPermissions("sys:userroute:update")
    public R update(@RequestBody UserRouteEntity userRoute){
			userRouteService.updateById(userRoute);

        return R.ok();
    }

    /**
     * 删除
     */
    @Login
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:userroute:delete")
    public R delete(@RequestBody Integer[] routeIds){
			userRouteService.deleteBatchIds(Arrays.asList(routeIds));

        return R.ok();
    }
    
    /**
     * 删除
     */
    @Login
    @RequestMapping("/deleteRoute")
    //@RequiresPermissions("sys:userroute:delete")
    public R deleteRoute(@RequestParam Integer routeId){
			userRouteService.deleteRoute(routeId);

        return R.ok();
    }
}
