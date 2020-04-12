package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.entity.SysDictEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 字典表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-28 11:47:36
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {

	List<SysDictEntity> getRaceList();
	
}
