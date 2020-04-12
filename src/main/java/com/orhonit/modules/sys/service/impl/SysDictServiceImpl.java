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

import com.orhonit.modules.sys.dao.SysDictDao;
import com.orhonit.modules.sys.entity.SysDictEntity;
import com.orhonit.modules.sys.service.SysDictService;


@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {
	
	@Autowired
	private SysDictDao sysDictDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysDictEntity> page = this.selectPage(
                new Query<SysDictEntity>(params).getPage(),
                new EntityWrapper<SysDictEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<SysDictEntity> getRaceList() {
		// TODO Auto-generated method stub
		return sysDictDao.getRaceList();
	}

}
