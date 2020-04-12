package com.orhonit.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.sys.dto.SignupDTO;
import com.orhonit.modules.sys.entity.OuSignupEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 课程报名
 */
@Mapper
public interface OuSignupDao extends BaseMapper<OuSignupEntity> {

    /**
     * 课程报名情况
     */
    List<SignupDTO> signupCountList(@Param("params") Map<String, Object> params);

    /**
     * 课程报名情况
     */
    Integer signupCount(@Param("params") Map<String, Object> params);

    /**
     * 查询用户报名课程id
     */
    String userIsSign(@Param("userId") String userId);
}
