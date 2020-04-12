package com.orhonit.modules.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.DateUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.annotation.LoginUser;
import com.orhonit.modules.app.entity.AppUserEntity;

@RestController
@RequestMapping("/app/birthday")
public class AppUserBirthdayController {
	
	/**
	 * APP用户端-生日提醒
	 * @param user
	 * @return
	 */
	@Login
	@GetMapping("bhdAndDjs")
	private R userBirthday(@LoginUser AppUserEntity user) {
		if(user.getUserBirthday()!=null) {
			Long birthday = user.getUserBirthday().getTime();	
			return R.ok().put("birthday", birthday).put("days",DateUtils.getBirthDays(user.getUserBirthday()));		
		}
		return R.parameterIsNul();
	}
}
