package com.orhonit.modules.app.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;

import com.orhonit.modules.app.dao.NewsCollcetionDao;
import com.orhonit.modules.app.entity.NewsCollcetionEntity;
import com.orhonit.modules.app.service.NewsCollcetionService;


@Service("newsCollcetionService")
public class NewsCollcetionServiceImpl extends ServiceImpl<NewsCollcetionDao, NewsCollcetionEntity> implements NewsCollcetionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params,long userId) {
        Page<NewsCollcetionEntity> page = this.selectPage(
                new Query<NewsCollcetionEntity>(params).getPage(),
                new EntityWrapper<NewsCollcetionEntity>().where("user_id={0}",userId)
        );
        
        return new PageUtils(page);
    }

}
