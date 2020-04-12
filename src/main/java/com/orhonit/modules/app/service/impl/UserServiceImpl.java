package com.orhonit.modules.app.service.impl;


import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.exception.RRException;
import com.orhonit.common.validator.Assert;
import com.orhonit.modules.app.dao.UserDao;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.app.form.LoginForm;
import com.orhonit.modules.app.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, AppUserEntity> implements UserService {

	@Override
	public AppUserEntity queryByMobile(String mobile) {
		AppUserEntity userEntity = new AppUserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public long login(LoginForm form) {
		AppUserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		
		if(!user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}
}
