package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-28 11:47:36
 */
public interface SysDictService extends IService<SysDictEntity> {
	
	List<SysDictEntity> getRaceList();
	
    PageUtils queryPage(Map<String, Object> params);
}

