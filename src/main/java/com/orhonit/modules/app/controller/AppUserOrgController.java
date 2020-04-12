package com.orhonit.modules.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.annotation.LoginUser;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.sys.entity.UserOrgEntity;
import com.orhonit.modules.sys.service.UserOrgService;
import com.orhonit.modules.sys.vo.IdAndNameVo;
import com.orhonit.modules.sys.vo.TreeVo;

@RestController
@RequestMapping("/app/userorg")
public class AppUserOrgController {
	
	 	@Autowired
	    private UserOrgService userOrgService;
	    /**
	     * 返回单位树
	     */
	 	@Login
	    @GetMapping("/getOrgTree")
	    public R getNewsModelTree() {
	    	List<TreeVo> getOrgTree = userOrgService.getOrgTree();
	    	return R.ok().put("getOrgTree",getOrgTree);
	    }
	    
	    /**
	     *根据单位名称模糊查询
	     */
	 	@Login
	    @RequestMapping("/listByLike")
	    //@RequiresPermissions("sys:userdept:list")
	    public R ListByLike(@RequestParam("orgName") String orgName){
	        List<IdAndNameVo> listByLike = userOrgService.ListByLike(orgName);

	        return R.ok().put("listByLike", listByLike);
	    }
	    
	    /**
	     * 列表
	     */
	 	@Login
	    @RequestMapping("/list")
	    //@RequiresPermissions("sys:userorg:list")
	    public R list(@RequestParam Map<String, Object> params){
	        PageUtils page = userOrgService.queryPage(params);

	        return R.ok().put("page", page);
	    }
	 
	    /**
	     * 信息
	     */
	 	@Login
	    @GetMapping("info")
	    //@RequiresPermissions("sys:userorg:info")
	    public R info(@LoginUser AppUserEntity user){
	 		if(user.getUserOrg()!=null) {
	 			UserOrgEntity userOrg = userOrgService.selectById(user.getUserOrg());
	 	        return R.ok().put("userOrg", userOrg);
	 		}
			return R.parameterIsNul();
	    }
	    /**
	     * 保存
	     */
	 	@Login
	    @RequestMapping("/save")
	    //@RequiresPermissions("sys:userorg:save")
	    public R save(@RequestBody UserOrgEntity userOrg){
				userOrgService.insert(userOrg);

	        return R.ok();
	    }

	    /**
	     * 修改
	     */
	 	@Login
	    @RequestMapping("/update")
	    //@RequiresPermissions("sys:userorg:update")
	    public R update(@RequestBody UserOrgEntity userOrg){
				userOrgService.updateById(userOrg);

	        return R.ok();
	    }

	    /**
	     * 删除
	     */
	 	@Login
	    @RequestMapping("/delete")
	    //@RequiresPermissions("sys:userorg:delete")
	    public R delete(@RequestBody Integer[] orgIds){
				userOrgService.deleteBatchIds(Arrays.asList(orgIds));

	        return R.ok();
	    }
	    
	    /**
	     *人员添加-登录人对应单位查询
	     */
	    @Login
	    @RequestMapping("/getOrgByUser")
	    //@RequiresPermissions("sys:userdept:list")
	    public R getOrgByUser(@LoginUser AppUserEntity user){
	    	if(user.getUserOrg()!=null){
	    		int userOrg= user.getUserOrg();
	    		
	    		IdAndNameVo idAndNameVo = userOrgService.getOrgByOrgId(userOrg);
		      	List<IdAndNameVo> idAndNameVoList = userOrgService.getDeptByOrgId(userOrg);
		      	
		        return R.ok().put("orgIdAndName", idAndNameVo).put("deptList",idAndNameVoList);
	    	}
	    	
	    	return R.error(-1, "管理员所在单位未找到，请联系超级管理员~");
	    }
}
