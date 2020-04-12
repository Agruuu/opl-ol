package com.orhonit.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.app.dao.AppUserDao;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.app.service.AppUserService;


@Service("appUserService")
public class AppUserServiceImpl extends ServiceImpl<AppUserDao, AppUserEntity> implements AppUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
//    	params.put("sidx", "user_id");
//    	params.put("order", "user_id");
        Page<AppUserEntity> page = this.selectPage(
                new Query<AppUserEntity>(params).getPage(),
                new EntityWrapper<AppUserEntity>()
        );
        page.setTotal(this.selectCount(new EntityWrapper<AppUserEntity>()));
        return new PageUtils(page);
    }
}
