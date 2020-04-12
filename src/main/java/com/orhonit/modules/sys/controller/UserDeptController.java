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
import com.orhonit.modules.sys.entity.UserDeptEntity;
import com.orhonit.modules.sys.service.UserDeptService;
import com.orhonit.modules.sys.vo.IdAndNameVo;
import com.orhonit.modules.sys.vo.TreeVo;



/**
 * 用户支部信息表
 *
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-08 09:43:09
 */
@RestController
@RequestMapping("sys/userdept")
public class UserDeptController {
    @Autowired
    private UserDeptService userDeptService;
    
    /**
     * 返回支部树
     */
    @GetMapping("/getDeptTree")
    public R getNewsModelTree() {
    	List<TreeVo> getDeptTree = userDeptService.getDeptTree();
    	return R.ok().put("getDeptTree",getDeptTree);
    }
    
    /**
     *根据支部名称模糊查询
     */
    @RequestMapping("/listByLike")
    //@RequiresPermissions("sys:userdept:list")
    public R ListByLike(@RequestParam("deptName") String deptName){
        List<IdAndNameVo> listByLike = userDeptService.ListByLike(deptName);

        return R.ok().put("listByLike", listByLike);
    }
    
    /**
     *根据id查支部名称和单位名称
     */
    @RequestMapping("/selectdobyid")
    //@RequiresPermissions("sys:userdept:list")
    public R selectBoById(@RequestParam("deptId") Integer deptId,@RequestParam("orgId") Integer orgId){
      

        return R.ok().put("deptAndOrg",userDeptService.selectBoById(deptId,orgId));
    }
      
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:userdept:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userDeptService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{deptId}")
    //@RequiresPermissions("sys:userdept:info")
    public R info(@PathVariable("deptId") Integer deptId){
			UserDeptEntity userDept = userDeptService.selectById(deptId);

        return R.ok().put("userDept", userDept);
    }
    
    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:userdept:save")
    public R save(@RequestBody UserDeptEntity userDept){
			userDeptService.insert(userDept);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:userdept:update")
    public R update(@RequestBody UserDeptEntity userDept){
			userDeptService.updateById(userDept);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:userdept:delete")
    public R delete(@RequestBody Integer[] deptIds){
			userDeptService.deleteBatchIds(Arrays.asList(deptIds));

        return R.ok();
    }

}
