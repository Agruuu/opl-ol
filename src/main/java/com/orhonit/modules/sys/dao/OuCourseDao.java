package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.dto.CourseDTO;
import com.orhonit.modules.sys.entity.OuCourseEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程信息
 */
@Mapper
public interface OuCourseDao extends BaseMapper<OuCourseEntity> {

    /**
     * 查询课程详情
     * @return
     */
    CourseDTO selectCourseInfo(@Param("courseId") Integer courseId);

    Integer selectByPropertiesCount(@Param("params") Map<String, Object> params);

    /**
     * 按条件查询
     * @param params
     * @return
     */
    List<CourseDTO> selectByProperties(@Param("params") Map<String, Object> params);

    /**
     * 查询课程（用户报名）
     * @param params
     * @return
     */
    List<CourseDTO> selectAlreadySignup(@Param("params") Map<String, Object> params);

    /**
     * 查询课程（用户未报名）
     * @param params
     * @return
     */
    List<CourseDTO> selectDidntSignup(@Param("params") Map<String, Object> params);
}
