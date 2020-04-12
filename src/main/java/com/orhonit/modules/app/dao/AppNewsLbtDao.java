package com.orhonit.modules.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.sys.entity.NewsLbtEntity;

@Mapper
public interface AppNewsLbtDao extends BaseMapper<NewsLbtEntity>{

	List<NewsLbtEntity> getALLlist();

}
