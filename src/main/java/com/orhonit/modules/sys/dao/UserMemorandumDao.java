package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.entity.UserMemorandumEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户备忘录表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-03-04 14:35:59
 */
@Mapper
public interface UserMemorandumDao extends BaseMapper<UserMemorandumEntity> {
	
}
