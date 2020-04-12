package com.orhonit.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.UserAreaDao;
import com.orhonit.modules.sys.dto.AreaDTO;
import com.orhonit.modules.sys.entity.UserAreaEntity;
import com.orhonit.modules.sys.service.UserAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("userAreaService")
public class UserAreaServiceImpl extends ServiceImpl<UserAreaDao, UserAreaEntity> implements UserAreaService {

    @Autowired
    private UserAreaDao userAreaDao;

    /**
     * 查询全部地区
     */
    @Override
    public List<AreaDTO> list() {
        return this.userAreaDao.list();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserAreaEntity> page = this.selectPage(
                new Query<UserAreaEntity>(params).getPage(),
                new EntityWrapper<UserAreaEntity>()
        );

        return new PageUtils(page);
    }

}
