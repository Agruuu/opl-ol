package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dto.*;
import com.orhonit.modules.sys.entity.OuCourseScheduleEntity;
import com.orhonit.modules.sys.entity.OuCourseEntity;

import java.util.List;
import java.util.Map;

/**
 * 课程信息
 */
public interface OuCourseService extends IService<OuCourseEntity> {

    /**
     * 按条件查询
     * @param params
     * @return
     */
    PageUtils courseQueryPage(Map<String, Object> params);

    /**
     * 按条件查询
     * @param params
     * @return
     */
    List<CourseDTO> selectByProperties(Map<String, Object> params);

    /**
     * 按条件查询
     * @param params
     * @return
     */
    List<CourseDTO> selectByPropertiesWeb(Map<String, Object> params);


    /**
     * 查询单个对象
     * @return
     */
    CourseDTO selectById(Integer courseId);

    /**
     * 查询单个对象
     * @return
     */
    CourseDTO selectByIdForApp(Integer courseId);

    /**
     * 查询课程时间
     * @param params
     * @return
     */
    List<CourseScheduleDTO> courseTimeList(Map<String, Object> params);

    /**
     * 查询课程时间
     * @param params
     * @return
     */
    PageUtils courseTimeListPage(Map<String, Object> params);

    /**
     * 查询上周，本周，下周课程
     */
    List<CourseForWeekDTO> selectCoursesForWeek(Map<String, Object> params);

    /**
     * 查询明天上午下午课程
     * @param params
     * @return
     */
    CourseForWeekDTO selectCoursesForToday(Map<String, Object> params);

    /**
     * 查询课程（用户报名）
     * @param params
     * @return
     */
    List<CourseDTO> selectAlreadySignup(Map<String, Object> params);

    /**
     * 查询课程（用户未报名）
     * @param params
     * @return
     */
    List<CourseDTO> selectDidntSignup(Map<String, Object> params);

    /**
     * 课程报名
     * @param courseId
     * @return
     */
    Integer courseSignup(Integer courseId, Integer userId);

    /**
     * 课程总报名人数
     */
    Integer signupCount(Map<String, Object> params);

    /**
     * 课程报名情况
     */
    List<SignupDTO> signupCountList(Map<String, Object> params);

    /**
     * 课程评价
     * @param courseCommentDTO
     * @return
     */
    Integer addCourseComment(CourseCommentDTO courseCommentDTO);


    /**
     * 添加课程
     * @param coursesDTO
     * @return
     */
    Integer saveCourse(CourseDTO coursesDTO);

    /**
     * 添加课程时间
     * @return
     */
    Integer saveCourseTime(OuCourseScheduleEntity ouCourseScheduleEntity);

    /**
     * 修改课程
     * @param courseDTO
     * @return
     */
    Integer updateCourse(CourseDTO courseDTO);

    /**
     * 修改课程时间
     * @param entity
     * @return
     */
    Integer updateCourseTime(OuCourseScheduleEntity entity);

    /**
     * 删除课程
     * @return
     */
    Integer deleteCourse(Integer[] ids);

    /**
     * 删除课程时间信息
     * @return
     */
    Integer deleteCourseTime(Integer[] ids);

    PageUtils queryPage(Map<String, Object> params);
}

