package com.orhonit.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.sys.entity.NewsModelEntity;
import com.orhonit.modules.sys.vo.NewsModelTreeVo;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-11 10:27:56
 */
@Mapper
public interface NewsModelDao extends BaseMapper<NewsModelEntity> {

	List<NewsModelTreeVo> getNewsModelTree();
	
}
