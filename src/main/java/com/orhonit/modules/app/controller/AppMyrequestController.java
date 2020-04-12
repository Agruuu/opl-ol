package com.orhonit.modules.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.annotation.LoginUser;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.sys.entity.MyrequestEntity;
import com.orhonit.modules.sys.service.MyrequestService;
import com.orhonit.modules.sys.vo.MyrequestEntityVo;

@RestController
@RequestMapping("/app/myrequest")
public class AppMyrequestController {
	
	@Autowired
    private MyrequestService myrequestService;
	
    /**
     * APP用户端-我的述求-添写述求
     */
	@Login
    @RequestMapping("/save")
    //@RequiresPermissions("sys:myrequest:save")
    public R save(@RequestBody MyrequestEntity myrequest,@LoginUser AppUserEntity user){
		if(user.getUserOrg()!=null&&myrequest.getMyreqDeptororg()!=null&&StringUtils.isNotBlank(myrequest.getMyreqReq())&&user.getUserId()!=null&&user.getUserDept()!=null){
			myrequest.setDeptId(user.getUserDept());
			myrequest.setReqUserId(user.getUserId());
			myrequest.setOrgId(user.getUserOrg());
			myrequestService.insert(myrequest);
	        return R.ok();
		}
		return R.parameterIsNul();
    }
	
    /**
     * 修改
     */
	@Login
    @RequestMapping("/update")
    //@RequiresPermissions("sys:myrequest:update")
    public R update(@RequestBody MyrequestEntity myrequest,@LoginUser AppUserEntity user){
    	if(user.getUserId()!=null) {
    		myrequest.setResUserId(user.getUserId());
    		myrequest.setMyreqIsRes(1);
    		myrequest.setMyreqResTime(new Date());
			myrequestService.updateById(myrequest);

        return R.ok();
    	}
    	return R.parameterIsNul();
    }
	
    /**
     * 删除
     */
	@Login
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:myrequest:delete")
    public R delete(@RequestBody Integer[] myreqIds){
			myrequestService.deleteBatchIds(Arrays.asList(myreqIds));

        return R.ok();
    }
	
	/**
    * APP用户端-我的述求-支部查询列表
    */
	@Login
    @GetMapping("/deptlist")
    //@RequiresPermissions("sys:myrequest:list")
    public R deptlist(@RequestParam Map<String, Object> params,@RequestAttribute Long userId){	
    	if (userId!=null&&params.get("myreqDeptororg")!=null) {
    		int isDeptOrOrg=Integer.parseInt(params.get("myreqDeptororg").toString());
            PageUtils page = myrequestService.myRequestPage(params,userId,isDeptOrOrg);
            return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }
	
//	/**
//    * APP用户端-我的述求-单位查询列表
//    */
//	@Login
//    @GetMapping("/orglist")
//    //@RequiresPermissions("sys:myrequest:list")
//    public R orglist(@RequestParam Map<String, Object> params,@RequestAttribute Long userId){	
//    	if (userId!=null) {
//    		int isDeptOrOrg=1;
//            PageUtils page = myrequestService.myRequestPage(params,userId,isDeptOrOrg);
//            return R.ok().put("page", page);
//    	}
//    	return R.parameterIsNul();
//    }
	
    /**
     * APP用户端-我的述求-诉求详情
     */
	@Login
    @RequestMapping("/info/{myreqId}")
    //@RequiresPermissions("sys:myrequest:info")
    public R info(@PathVariable("myreqId") Integer myreqId){
    	MyrequestEntityVo myrequest = myrequestService.selectInfoMyrequest(myreqId);

        return R.ok().put("myrequest", myrequest);
    }
}
