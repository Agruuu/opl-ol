package com.orhonit.modules.sys.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.sys.dto.CourseScheduleDTO;
import com.orhonit.modules.sys.entity.OuCourseScheduleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 课程时间表
 */
@Mapper
public interface OuCourseScheduleDao extends BaseMapper<OuCourseScheduleEntity> {

    /**
     * 后台查询显示
     */
    List<CourseScheduleDTO> list(@Param("params") Map<String, Object> params);

    Integer listCount(@Param("params") Map<String, Object> params);

    /**
     * 按条件查询
     */
    List<CourseScheduleDTO> selectByProperties(@Param("params") Map<String, Object> params);

    /**
     * 批量添加
     */
    Integer batchInsert(List<CourseScheduleDTO> list);

    /**
     * 按课程id删除
     */
    Integer deleteByCourseId(@Param("courseId") Integer courseId);
}
