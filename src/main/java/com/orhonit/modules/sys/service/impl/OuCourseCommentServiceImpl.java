package com.orhonit.modules.sys.service.impl;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.OuCourseCommentDao;
import com.orhonit.modules.sys.dto.CourseCommentDTO;
import com.orhonit.modules.sys.entity.OuCourseCommentEntity;
import com.orhonit.modules.sys.service.OuCourseCommentService;
import com.orhonit.modules.sys.utils.PageParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("ouCourseCommentService")
public class OuCourseCommentServiceImpl extends ServiceImpl<OuCourseCommentDao, OuCourseCommentEntity> implements OuCourseCommentService {

    @Autowired
    private OuCourseCommentDao ouCourseCommentDao;

    @Override
    public List<CourseCommentDTO> list(Map<String, Object> params) {
        params = PageParamsUtil.getLimit(params);
        return this.ouCourseCommentDao.list(params);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OuCourseCommentEntity> page = this.selectPage(
                new Query<OuCourseCommentEntity>(params).getPage(),
                new EntityWrapper<OuCourseCommentEntity>()
        );

        return new PageUtils(page);
    }

}
