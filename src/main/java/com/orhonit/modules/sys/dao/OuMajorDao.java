package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.dto.MajorDTO;
import com.orhonit.modules.sys.entity.OuMajorEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 专业
 */
@Mapper
public interface OuMajorDao extends BaseMapper<OuMajorEntity> {

    /** 下拉框 查找全部 */
    List<MajorDTO> comboList();

    /** 查找全部 */
    List<MajorDTO> findByProperties(@Param("params") Map<String, Object> params);

    /**  */
    /** 查找所有院系(父专业) */
    List<MajorDTO> findParentMajorList(@Param("params")Map<String, Object> params);

    /** 查找所有专业 */
    List<MajorDTO> findAllMajorList(@Param("params")Map<String, Object> params);

    /** 查找所有院系下面的所有专业 */
    List<MajorDTO> findAllMajorByParentId(@Param("params")Map<String, Object> params);

    /** 查专业详情 */
    MajorDTO findMajorById(Integer majorId);
}
