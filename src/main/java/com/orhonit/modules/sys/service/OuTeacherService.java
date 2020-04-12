package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dto.TeacherDTO;
import com.orhonit.modules.sys.entity.OuTeacherEntity;

import java.util.List;
import java.util.Map;

/**
 * 教师表
 */
public interface OuTeacherService extends IService<OuTeacherEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<TeacherDTO> selectByProperties(Map<String, Object> params);

    PageUtils teacherQueryPage(Map<String, Object> params);

    TeacherDTO selectById(String teacherId);

    boolean save(TeacherDTO teacherDTO);

    boolean update(TeacherDTO teacherDTO);

    boolean delete(String teacherId);
}

