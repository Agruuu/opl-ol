package com.orhonit.modules.sys.controller;

import java.util.Arrays;
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
import com.orhonit.modules.sys.entity.SysUserEntity;
import com.orhonit.modules.sys.entity.UserPhoneNumCardEntity;
import com.orhonit.modules.sys.service.UserPhoneNumCardService;



/**
 * 用户手机识别码表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-03-04 10:13:59
 */
@RestController
@RequestMapping("sys/userphonenumcard")
public class UserPhoneNumCardController extends AbstractController{
    @Autowired
    private UserPhoneNumCardService userPhoneNumCardService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:userphonenumcard:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userPhoneNumCardService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Login
    @RequestMapping("/info/{phoneId}")
    //@RequiresPermissions("sys:userphonenumcard:info")
    public R info(@PathVariable("phoneId") Integer phoneId){
		UserPhoneNumCardEntity userPhoneNumCard = userPhoneNumCardService.selectById(phoneId);
        return R.ok().put("userPhoneNumCard", userPhoneNumCard);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:userphonenumcard:save")
    public R save(@RequestBody UserPhoneNumCardEntity userPhoneNumCard){
    	
    		userPhoneNumCardService.insert(userPhoneNumCard);

            return R.ok();

    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("sys:userphonenumcard:delete")
    public R delete(@RequestBody Integer[] phoneIds){
    
			userPhoneNumCardService.deleteBatchIds(Arrays.asList(phoneIds));

        return R.ok();
    	
    }

}
