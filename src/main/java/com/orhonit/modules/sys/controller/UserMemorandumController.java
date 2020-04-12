package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.modules.sys.entity.UserMemorandumEntity;
import com.orhonit.modules.sys.service.UserMemorandumService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;



/**
 * 用户备忘录表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-03-04 14:35:59
 */
@RestController
@RequestMapping("sys/usermemorandum")
public class UserMemorandumController extends AbstractController{
    @Autowired
    private UserMemorandumService userMemorandumService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:usermemorandum:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userMemorandumService.queryPage(params,getUserId());

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{memorandumId}")
    @RequiresPermissions("sys:usermemorandum:info")
    public R info(@PathVariable("memorandumId") Integer memorandumId){
			UserMemorandumEntity userMemorandum = userMemorandumService.selectById(memorandumId);

        return R.ok().put("userMemorandum", userMemorandum);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:usermemorandum:save")
    public R save(@RequestBody UserMemorandumEntity userMemorandum){
			userMemorandumService.insert(userMemorandum);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:usermemorandum:update")
    public R update(@RequestBody UserMemorandumEntity userMemorandum){
			userMemorandumService.updateById(userMemorandum);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:usermemorandum:delete")
    public R delete(@RequestBody Integer[] memorandumIds){
			userMemorandumService.deleteBatchIds(Arrays.asList(memorandumIds));

        return R.ok();
    }

}
