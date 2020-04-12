package com.orhonit.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.OuTeacherDao;
import com.orhonit.modules.sys.dto.TeacherDTO;
import com.orhonit.modules.sys.entity.OuTeacherEntity;
import com.orhonit.modules.sys.service.OuTeacherService;
import com.orhonit.modules.sys.utils.PageParamsUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("ouTeacherService")
public class OuTeacherServiceImpl extends ServiceImpl<OuTeacherDao, OuTeacherEntity> implements OuTeacherService {

    @Autowired
    private OuTeacherDao ouTeacherDao;

    @Override
    public List<TeacherDTO> selectByProperties(Map<String, Object> params) {
        //params = PageParamsUtil.getLimitWeb(params);
        List<TeacherDTO> list = ouTeacherDao.selectByProperties(params);
        return list;
    }

    @Override
    public PageUtils teacherQueryPage(Map<String, Object> params) {
        params = PageParamsUtil.getLimitWeb(params);
        List<TeacherDTO> list = this.ouTeacherDao.selectByProperties(params);
        Integer count = this.ouTeacherDao.queryCount(params);
        Integer pageSize = Integer.parseInt(params.get("length").toString());
        Integer currPage = Integer.parseInt(params.get("currentPage").toString());
        PageUtils pageUtils = new PageUtils(list, count, pageSize, currPage);
        return pageUtils;
    }

    @Override
    public TeacherDTO selectById(String teacherId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("teacherId", teacherId);
        List<TeacherDTO> list = ouTeacherDao.selectByProperties(params);
        if(null != list && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean save(@RequestBody TeacherDTO teacherDTO) {
        OuTeacherEntity entity = new OuTeacherEntity();
        BeanUtils.copyProperties(teacherDTO, entity);
        entity.setTeacherState("Y");
        Integer result = ouTeacherDao.insert(entity);
        if(result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(@RequestBody TeacherDTO teacherDTO) {
        OuTeacherEntity entity = new OuTeacherEntity();
        BeanUtils.copyProperties(teacherDTO, entity);
        Integer result = ouTeacherDao.updateById(entity);
        if(result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String teacherId) {
        OuTeacherEntity entity = super.selectById(teacherId);
        entity.setTeacherState("D");
        Integer result = ouTeacherDao.updateById(entity);
        if(result > 0) {
            return true;
        }
        return false;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OuTeacherEntity> page = this.selectPage(
                new Query<OuTeacherEntity>(params).getPage(),
                new EntityWrapper<OuTeacherEntity>()
        );

        return new PageUtils(page);
    }

}
