package com.orhonit.modules.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.sys.entity.UserPhoneNumCardEntity;

/**
 * 用户手机识别码表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-03-04 10:13:59
 */
public interface UserPhoneNumCardService extends IService<UserPhoneNumCardEntity> {

    PageUtils queryPage(Map<String, Object> params);

	void updateByLoginUserId(UserPhoneNumCardEntity userPhoneNumCard,AppUserEntity user);
}

