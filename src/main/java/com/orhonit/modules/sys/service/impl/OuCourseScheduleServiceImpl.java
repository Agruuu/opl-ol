package com.orhonit.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.OuCourseScheduleDao;
import com.orhonit.modules.sys.dto.CourseScheduleDTO;
import com.orhonit.modules.sys.entity.OuCourseScheduleEntity;
import com.orhonit.modules.sys.service.OuCourseScheduleService;
import com.orhonit.modules.sys.utils.PageParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("ouCourseScheduleService")
public class OuCourseScheduleServiceImpl extends ServiceImpl<OuCourseScheduleDao, OuCourseScheduleEntity> implements OuCourseScheduleService {

    @Autowired
    private OuCourseScheduleDao ouCourseScheduleDao;

    /**
     * 按条件查询
     */
    @Override
    public List<CourseScheduleDTO> weekData(Map<String, Object> params) {
        List<CourseScheduleDTO> list = ouCourseScheduleDao.selectByProperties(params);
        return list;
    }

    /**
     * 按条件查询
     */
    @Override
    public List<CourseScheduleDTO> selectByProperties(Map<String, Object> params) {
        params = PageParamsUtil.getLimit(params);
        List<CourseScheduleDTO> list = ouCourseScheduleDao.selectByProperties(params);
        return list;
    }

    /**
     * 批量添加 课程时间信息
     */
    @Override
    public Integer batchInsert(List<CourseScheduleDTO> list) {
        Integer result = ouCourseScheduleDao.batchInsert(list);
        return result;
    }

    /**
     * 修改课程
     * @param entity
     * @return
     */
    @Override
    public Integer update(OuCourseScheduleEntity entity) {
        Integer result = this.ouCourseScheduleDao.updateById(entity);
        return result;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OuCourseScheduleEntity> page = this.selectPage(
                new Query<OuCourseScheduleEntity>(params).getPage(),
                new EntityWrapper<OuCourseScheduleEntity>()
        );

        return new PageUtils(page);
    }

}
