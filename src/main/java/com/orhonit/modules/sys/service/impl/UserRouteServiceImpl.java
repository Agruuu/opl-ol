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

import com.orhonit.modules.sys.dao.UserRouteDao;
import com.orhonit.modules.sys.entity.UserRouteEntity;
import com.orhonit.modules.sys.service.UserRouteService;


@Service("userRouteService")
public class UserRouteServiceImpl extends ServiceImpl<UserRouteDao, UserRouteEntity> implements UserRouteService {

	@Autowired
	private UserRouteDao userRouteDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserRouteEntity> page = this.selectPage(
                new Query<UserRouteEntity>(params).getPage(),
                new EntityWrapper<UserRouteEntity>().orderBy("route_id DESC")
        );

        return new PageUtils(page);
    }

	@Override
	public List<UserRouteEntity> getRouteList(int deptId) {
		// TODO Auto-generated method stub
		return userRouteDao.getRouteList(deptId);
	}

	@Override
	public void deleteRoute(Integer routeId) {
		// TODO Auto-generated method stub
		userRouteDao.deleteStations(routeId);
		userRouteDao.deleteById(routeId);

	}

}
