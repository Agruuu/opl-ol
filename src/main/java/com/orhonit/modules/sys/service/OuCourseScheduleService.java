package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dto.CourseScheduleDTO;
import com.orhonit.modules.sys.entity.OuCourseScheduleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程时间表
 */
public interface OuCourseScheduleService extends IService<OuCourseScheduleEntity> {

    /**
     * 按条件查询
     */
    List<CourseScheduleDTO> weekData(@Param("params") Map<String, Object> params);

    /**
     * 按条件查询
     */
    List<CourseScheduleDTO> selectByProperties(@Param("params") Map<String, Object> params);

    /**
     * 批量添加课程时间
     */
    Integer batchInsert(List<CourseScheduleDTO> list);

    /**
     * 修改课程时间
     * @param entity
     * @return
     */
    Integer update(OuCourseScheduleEntity entity);

    PageUtils queryPage(Map<String, Object> params);
}

