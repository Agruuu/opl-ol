package com.orhonit.modules.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.NewsEntity;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-11 09:10:07
 */
public interface NewsService extends IService<NewsEntity> {

    PageUtils queryPage(Map<String, Object> params);

	void NewtoTop(Integer newTopNew, Integer newId);

	void deleteByNewId(Integer newId);

}

