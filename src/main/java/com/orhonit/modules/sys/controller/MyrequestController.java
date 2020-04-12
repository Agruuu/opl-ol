package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.sys.entity.MyrequestEntity;
import com.orhonit.modules.sys.service.MyrequestService;
import com.orhonit.modules.sys.vo.MyrequestEntityVo;



/**
 * 我的述求
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-25 16:47:20
 */
@RestController
@RequestMapping("sys/myrequest")
public class MyrequestController extends AbstractController{
    @Autowired
    private MyrequestService myrequestService;

    /**
     * PC服务端-我的述求-查询列表
     */
    @GetMapping("/list")
    //@RequiresPermissions("sys:myrequest:list")
    public R list(@RequestParam Map<String, Object> params){
    	if(getUser().getUserDept()!=null&&getUser().getUserOrg()!=null) {
    		int deptId = getUser().getUserOrg();
			int orgId = getUser().getUserOrg();
			PageUtils page = myrequestService.queryPage(params,deptId,orgId);
			return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }


    /**
     * PC服务端-我的述求-诉求详情
     */
    @RequestMapping("/info/{myreqId}")
    //@RequiresPermissions("sys:myrequest:info")
    public R info(@PathVariable("myreqId") Integer myreqId){
    	MyrequestEntityVo myrequest = myrequestService.selectInfoMyrequest(myreqId);

        return R.ok().put("myrequest", myrequest);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:myrequest:save")
    public R save(@RequestBody MyrequestEntity myrequest){
			myrequestService.insert(myrequest);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:myrequest:update")
    public R update(@RequestBody MyrequestEntity myrequest){
    	if(getUserId()!=null) {
    		myrequest.setResUserId(getUserId());
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
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:myrequest:delete")
    public R delete(@RequestBody Integer[] myreqIds){
			myrequestService.deleteBatchIds(Arrays.asList(myreqIds));

        return R.ok();
    }

}
