package com.orhonit.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.NewsModelEntity;
import com.orhonit.modules.sys.vo.NewsModelTreeVo;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-11 10:27:56
 */
public interface NewsModelService extends IService<NewsModelEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<NewsModelTreeVo> getNewsModelTree();
}

