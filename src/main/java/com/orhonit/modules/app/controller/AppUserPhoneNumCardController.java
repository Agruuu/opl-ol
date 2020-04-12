package com.orhonit.modules.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.annotation.LoginUser;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.sys.entity.UserPhoneNumCardEntity;
import com.orhonit.modules.sys.service.UserPhoneNumCardService;

@RestController
@RequestMapping("/app/userphonenumcard")
public class AppUserPhoneNumCardController {
    @Autowired
    private UserPhoneNumCardService userPhoneNumCardService;
    
	  /**
     * 修改
     */
	@Login
    @RequestMapping("/update")
    //@RequiresPermissions("sys:userphonenumcard:update")
    public R update(@RequestBody UserPhoneNumCardEntity userPhoneNumCard,@LoginUser AppUserEntity user){
    	if(userPhoneNumCard.getPhoneNumCard()!=null){
			userPhoneNumCardService.updateByLoginUserId(userPhoneNumCard,user);
			return R.ok();
    	}
		return R.parameterIsNul();
    }
}
