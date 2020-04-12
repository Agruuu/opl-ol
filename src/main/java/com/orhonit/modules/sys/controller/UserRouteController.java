package com.orhonit.modules.sys.controller;

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
import com.orhonit.modules.sys.entity.UserRouteEntity;
import com.orhonit.modules.sys.service.UserRouteService;



/**
 * 乘车路线表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-11 17:21:10
 */
@RestController
@RequestMapping("sys/userroute")
public class UserRouteController extends AbstractController{
    @Autowired
    private UserRouteService userRouteService;

    /**
     * 列表
     */
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
    @RequestMapping("/routelist")
   //@RequiresPermissions("sys:userroute:list")
   public R routeList(){
    	if(getUser().getUserDept()!=null) {
    		int deptId = getUser().getUserDept();
    	   	List<UserRouteEntity> UserRouteEntityList = userRouteService.getRouteList(deptId);
   	        return R.ok().put("userRouteEntityList", UserRouteEntityList);
    	}
    	return R.parameterIsNul();
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{routeId}")
    //@RequiresPermissions("sys:userroute:info")
    public R info(@PathVariable("routeId") Integer routeId){
			UserRouteEntity userRoute = userRouteService.selectById(routeId);

        return R.ok().put("userRoute", userRoute);
    }
 
    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:userroute:save")
    public R save(@RequestBody UserRouteEntity userRoute){
    	if(getUser().getUserDept()!=null) {
        	userRoute.setCrtTime(new Date());
        	userRoute.setDeptId(getUser().getUserDept());
    	    userRouteService.insert(userRoute);
            return R.ok();
    	}
    	return R.parameterIsNul();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:userroute:update")
    public R update(@RequestBody UserRouteEntity userRoute){
			userRouteService.updateById(userRoute);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:userroute:delete")
    public R delete(@RequestBody Integer[] routeIds){
			userRouteService.deleteBatchIds(Arrays.asList(routeIds));

        return R.ok();
    }
    
    /**
     * 删除
     */
    @RequestMapping("/deleteRoute")
    //@RequiresPermissions("sys:userroute:delete")
    public R deleteRoute(@RequestParam Integer routeId){
			userRouteService.deleteRoute(routeId);

        return R.ok();
    }

}
