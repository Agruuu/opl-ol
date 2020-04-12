package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dto.CourseCommentDTO;
import com.orhonit.modules.sys.entity.OuCourseCommentEntity;

import java.util.List;
import java.util.Map;

/**
 * 课程评价
 */
public interface OuCourseCommentService extends IService<OuCourseCommentEntity> {

    List<CourseCommentDTO> list(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params);
}

