package com.orhonit.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.OuSignupDao;
import com.orhonit.modules.sys.dto.SignupDTO;
import com.orhonit.modules.sys.entity.OuSignupEntity;
import com.orhonit.modules.sys.service.OuSignupService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("ouSignupService")
public class OuSignupServiceImpl extends ServiceImpl<OuSignupDao, OuSignupEntity> implements OuSignupService {

    @Autowired
    private OuSignupDao ouSignupDao;


    /**
     * 课程总报名人数
     */
    @Override
    public Integer signupCount(@Param("params") Map<String, Object> params) {
        Integer count = this.ouSignupDao.signupCount(params);
        return count;
    }

    /**
     * 课程报名情况
     */
    @Override
    public List<SignupDTO> signupCountList(@Param("params") Map<String, Object> params) {
        List<SignupDTO> list = this.ouSignupDao.signupCountList(params);
        return list;
    }

    /**
     * 课程报名
     * @param courseId
     * @return
     */
    @Override
    public Integer signup(String courseId, Integer userId) {
        OuSignupEntity entity = new OuSignupEntity();
        entity.setSignUserId(userId);
        entity.setSignCourseId(Integer.parseInt(courseId));
        entity.setSignDate(new Date());
        Integer result = this.ouSignupDao.insert(entity);
        return result;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OuSignupEntity> page = this.selectPage(
                new Query<OuSignupEntity>(params).getPage(),
                new EntityWrapper<OuSignupEntity>()
        );

        return new PageUtils(page);
    }

}
