package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
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
import com.orhonit.modules.sys.entity.UserOrgEntity;
import com.orhonit.modules.sys.service.UserOrgService;
import com.orhonit.modules.sys.vo.IdAndNameVo;
import com.orhonit.modules.sys.vo.TreeVo;



/**
 * app用户所在单位表
 *
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-14 16:29:13
 */
@RestController
@RequestMapping("sys/userorg")
public class UserOrgController extends AbstractController{
    @Autowired
    private UserOrgService userOrgService;
    
    /**
     * 返回单位树
     */
    @GetMapping("/getOrgTree")
    public R getNewsModelTree() {
    	List<TreeVo> getOrgTree = userOrgService.getOrgTree();
    	return R.ok().put("getOrgTree",getOrgTree);
    }
    
    /**
     *根据单位名称模糊查询
     */
    @RequestMapping("/listByLike")
    //@RequiresPermissions("sys:userdept:list")
    public R ListByLike(@RequestParam("orgName") String orgName){
        List<IdAndNameVo> listByLike = userOrgService.ListByLike(orgName);

        return R.ok().put("listByLike", listByLike);
    }
    
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:userorg:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userOrgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orgId}")
    //@RequiresPermissions("sys:userorg:info")
    public R info(@PathVariable("orgId") Integer orgId){
			UserOrgEntity userOrg = userOrgService.selectById(orgId);

        return R.ok().put("userOrg", userOrg);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:userorg:save")
    public R save(@RequestBody UserOrgEntity userOrg){
			userOrgService.insert(userOrg);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:userorg:update")
    public R update(@RequestBody UserOrgEntity userOrg){
			userOrgService.updateById(userOrg);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:userorg:delete")
    public R delete(@RequestBody Integer[] orgIds){
			userOrgService.deleteBatchIds(Arrays.asList(orgIds));

        return R.ok();
    }
    
    /**
     *人员添加-登录人对应单位和支部列表查询
     */
    @RequestMapping("/getOrgByUser")
    //@RequiresPermissions("sys:userdept:list")
    public R getOrgByUser(){
    	if(getUser().getUserOrg()!=null){
    		int userOrg= getUser().getUserOrg();
    		
    		IdAndNameVo idAndNameVo = userOrgService.getOrgByOrgId(userOrg);
	      	List<IdAndNameVo> idAndNameVoList = userOrgService.getDeptByOrgId(userOrg);
	      	if(idAndNameVoList.size()==0) {
	      		return R.error(-1, "管理员所在单位下无支部，请添加支部后重试~"); 
	      	}
	      	return R.ok().put("orgIdAndName", idAndNameVo).put("deptList",idAndNameVoList);
    	}	
    	return R.error(-1, "管理员所在单位未找到，请联系超级管理员~");
    }

}
