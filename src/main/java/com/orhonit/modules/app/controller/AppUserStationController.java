package com.orhonit.modules.app.controller;

import java.util.Arrays;
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
import com.orhonit.modules.sys.entity.UserStationEntity;
import com.orhonit.modules.sys.service.UserStationService;

@RestController
@RequestMapping("/app/appstation")
public class AppUserStationController {
	
    @Autowired
    private UserStationService userStationService;
    
    /**
     * 列表
     */
    @Login
    @RequestMapping("/list")
    //@RequiresPermissions("sys:userstation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userStationService.queryPage(params);

        return R.ok().put("page", page);
    }
	
    /**
     *乘车地点列表
     */
	@Login
    @RequestMapping("/stationList")
    //@RequiresPermissions("sys:userstation:list")
    public R stationList(@RequestParam Integer routeId){
        List<UserStationEntity> stationList = userStationService.getStationList(routeId);

        return R.ok().put("stationList", stationList);
    }
	
    /**
     * 信息
     */
	@Login
    @RequestMapping("/info/{stationId}")
    //@RequiresPermissions("sys:userstation:info")
    public R info(@PathVariable("stationId") Integer stationId){
			UserStationEntity userStation = userStationService.selectById(stationId);

        return R.ok().put("userStation", userStation);
    }

    /**
     * 保存
     */
	@Login
    @RequestMapping("/save")
    //@RequiresPermissions("sys:userstation:save")
    public R save(@RequestBody UserStationEntity userStation){
			userStationService.insert(userStation);
			
        return R.ok();
    }

    /**
     * 修改
     */
	@Login
    @RequestMapping("/update")
    //@RequiresPermissions("sys:userstation:update")
    public R update(@RequestBody UserStationEntity userStation){
			userStationService.updateById(userStation);
        return R.ok();
    }

    /**
     * 删除
     */
	@Login
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:userstation:delete")
    public R delete(@RequestBody Integer[] stationIds){
			userStationService.deleteBatchIds(Arrays.asList(stationIds));

        return R.ok();
    }
}
