package com.orhonit.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;

import com.orhonit.modules.sys.dao.UserStationDao;
import com.orhonit.modules.sys.entity.UserStationEntity;
import com.orhonit.modules.sys.service.UserStationService;


@Service("userStationService")
public class UserStationServiceImpl extends ServiceImpl<UserStationDao, UserStationEntity> implements UserStationService {
	
	@Autowired
	private UserStationDao userStationDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserStationEntity> page = this.selectPage(
                new Query<UserStationEntity>(params).getPage(),
                new EntityWrapper<UserStationEntity>()
        );

        return new PageUtils(page);
    }
	@Override
	public List<UserStationEntity> getStationList(Integer routeId) {
		// TODO Auto-generated method stub
		return userStationDao.getStationList(routeId);
	}


}
