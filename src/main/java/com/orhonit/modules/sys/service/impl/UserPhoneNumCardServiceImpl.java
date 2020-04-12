package com.orhonit.modules.sys.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.sys.dao.UserPhoneNumCardDao;
import com.orhonit.modules.sys.entity.UserPhoneNumCardEntity;
import com.orhonit.modules.sys.service.UserPhoneNumCardService;


@Service("userPhoneNumCardService")
public class UserPhoneNumCardServiceImpl extends ServiceImpl<UserPhoneNumCardDao, UserPhoneNumCardEntity> implements UserPhoneNumCardService {
	
	@Autowired
	private UserPhoneNumCardDao userPhoneNumCardDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserPhoneNumCardEntity> page = this.selectPage(
                new Query<UserPhoneNumCardEntity>(params).getPage(),
                new EntityWrapper<UserPhoneNumCardEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public void updateByLoginUserId(UserPhoneNumCardEntity userPhoneNumCard,AppUserEntity user) {
		userPhoneNumCard.setAreaId(user.getUserArea());
		userPhoneNumCard.setDeptId(user.getUserDept());
		userPhoneNumCard.setOrgId(user.getUserOrg());
		userPhoneNumCard.setUserId(user.getUserId());
		UserPhoneNumCardEntity uPNC = userPhoneNumCardDao.selectByUserId(user.getUserId());
		if(uPNC==null){	
			userPhoneNumCardDao.insertAllColumn(userPhoneNumCard);
		}else if(!uPNC.getPhoneNumCard().equals(userPhoneNumCard.getPhoneNumCard())) {
			userPhoneNumCardDao.updateByLoginUserId(userPhoneNumCard);
		}
		
	}

}
