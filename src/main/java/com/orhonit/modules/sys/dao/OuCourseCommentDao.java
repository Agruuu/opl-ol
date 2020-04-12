package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.dto.CourseCommentDTO;
import com.orhonit.modules.sys.entity.OuCourseCommentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程评价
 */
@Mapper
public interface OuCourseCommentDao extends BaseMapper<OuCourseCommentEntity> {

    List<CourseCommentDTO> list(@Param("params")Map<String, Object> params);
}
