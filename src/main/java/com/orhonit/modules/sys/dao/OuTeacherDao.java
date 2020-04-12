package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.dto.TeacherDTO;
import com.orhonit.modules.sys.entity.OuTeacherEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 教师表
 */
@Mapper
public interface OuTeacherDao extends BaseMapper<OuTeacherEntity> {

    List<TeacherDTO> selectByProperties(@Param("params") Map<String, Object> params);

    Integer queryCount(@Param("params") Map<String, Object> params);
}
