package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dto.MajorDTO;
import com.orhonit.modules.sys.entity.OuMajorEntity;
import com.orhonit.modules.sys.utils.PageList;

import java.util.List;
import java.util.Map;

/**
 * 专业
 */
public interface OuMajorService extends IService<OuMajorEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /** 下拉框 查找全部 */
    List<MajorDTO> comboList();

    /** 查找全部 */
    List<MajorDTO> findByProperties(Map<String, Object> params);

    /**  */
    /** 查找所有院系(父专业) */
    //List<MajorDTO> findMajorList(Map<String, Object> params);

    /** 查找所有专业 */
    //List<MajorDTO> findAllMajorList(Map<String, Object> params);

    /** 查找所有院系下面的所有专业 */
//    List<MajorDTO> findAllMajorByParentId(Map<String, Object> params);

    /** 查专业详情 */
    MajorDTO findMajorById(Integer majorId);

    /** 添加院校 */
    boolean save(MajorDTO majorDTO);

    /** 添加专业 */
//    boolean saveMajor(MajorDTO majorDTO);

    /** 修改院校 */
    boolean update(MajorDTO majorDTO);

    boolean delete(String majorId);

    /** 修改专业 */
//    boolean updateMajor(MajorDTO majorDTO);
    /** 添加 */
    /** 修改 */
}

