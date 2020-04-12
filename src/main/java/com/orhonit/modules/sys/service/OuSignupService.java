package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dto.SignupDTO;
import com.orhonit.modules.sys.entity.OuSignupEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程报名
 */
public interface OuSignupService extends IService<OuSignupEntity> {

    /**
     * 课程总报名人数
     */
    Integer signupCount(Map<String, Object> params);

    /**
     * 课程报名情况
     */
    List<SignupDTO> signupCountList(Map<String, Object> params);

    /**
     * 课程报名
     * @param courseId
     * @return
     */
    Integer signup(String courseId, Integer userId);

    PageUtils queryPage(Map<String, Object> params);
}

