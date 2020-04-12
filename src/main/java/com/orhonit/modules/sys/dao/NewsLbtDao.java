package com.orhonit.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.sys.entity.NewsLbtEntity;

/**
 * 
 * 
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-14 11:09:47
 */
@Mapper
public interface NewsLbtDao extends BaseMapper<NewsLbtEntity> {

	List<NewsLbtEntity> getALLlist();
	
}
