package com.orhonit.modules.sys.service.impl;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.OuMajorDao;
import com.orhonit.modules.sys.dto.MajorDTO;
import com.orhonit.modules.sys.entity.OuMajorEntity;
import com.orhonit.modules.sys.service.OuMajorService;
import com.orhonit.modules.sys.utils.PageParamsUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("ouMajorService")
public class OuMajorServiceImpl extends ServiceImpl<OuMajorDao, OuMajorEntity> implements OuMajorService {

    @Autowired
    private OuMajorDao ouMajorDao;

    /** 下拉框 查找全部 */
    @Override
    public List<MajorDTO> comboList() {
        return this.ouMajorDao.comboList();
    }

    @Override
    public List<MajorDTO> findByProperties(Map<String, Object> params) {
        params = PageParamsUtil.getLimit(params);
        List<MajorDTO> list = ouMajorDao.findByProperties(params);
        return list;
    }

    @Override
    public MajorDTO findMajorById(Integer majorId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("majorId", majorId);
        List<MajorDTO> majorDTOList = ouMajorDao.findByProperties(params);
        if(null != majorDTOList && majorDTOList.size() > 0) {
            majorDTOList.get(0);
        }
        return null;
    }

    @Override
    public boolean save(MajorDTO majorDTO) {
        OuMajorEntity entity = new OuMajorEntity();
        BeanUtils.copyProperties(majorDTO, entity);
        entity.setMajorIsUse("Y");
        entity.setMajorSupperId(0);
        boolean flag = super.insert(entity);
        return flag;
    }

    @Override
    public boolean update(MajorDTO majorDTO) {
        OuMajorEntity entity = ouMajorDao.selectById(majorDTO.getMajorId());
        entity.setMajorTitle(majorDTO.getMajorTitle());
        boolean flag = super.updateById(entity);
        return flag;
    }

    @Override
    public boolean delete(String majorId) {
        OuMajorEntity entity = super.selectById(majorId);
        entity.setMajorIsUse("D");
        Integer result = ouMajorDao.updateById(entity);
        if(result > 0) {
            return true;
        }
        return false;
    }

//    @Override
//    public PageList<MajorDTO> findByProperties(Map<String, Object> params) {
//        PageList<MajorDTO> page = new PageList<MajorDTO>();
//        List<MajorDTO> countList = ouMajorDao.findByProperties(params);
//        int pageCount = countList.size();
//        page.setCurrentPage(Integer.parseInt(params.get("currentPage").toString()));
//        page.setTotalRecord(pageCount);
//        page.setStartIndexEndIndex();
//
//        params.put("startRecord", page.getStartRecord());
//        params.put("pageSize", page.getPageSize());
//        List<MajorDTO> majorDTOList = ouMajorDao.findByProperties(params);
//        page.setDatas(majorDTOList);
//        return page;
//    }

//    @Override
//    public List<MajorDTO> findMajorList(Map<String, Object> params) {
////        List<MajorDTO> countList = ouMajorDao.findByPropertys(params);
////        int pageCount = countList.size();
//        params = PageParamsUtil.getLimit(params);
//        List<MajorDTO> majorDTOList = ouMajorDao.findByProperties(params);
//        return majorDTOList;
//    }

//    @Override
//    public List<MajorDTO> findAllMajorList(Map<String, Object> params) {
//        params = PageParamsUtil.getLimit(params);
//        List<MajorDTO> majorDTOList = ouMajorDao.findByProperties(params);
//        return majorDTOList;
//    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OuMajorEntity> page = this.selectPage(
                new Query<OuMajorEntity>(params).getPage(),
                new EntityWrapper<OuMajorEntity>()
        );

        return new PageUtils(page);
    }

    private static Map<String, Object> getLimit(Map<String, Object> params) {
        int pageSize = 20;
        int currentPage = Integer.parseInt(params.get("currentPage").toString());
        int startIndex = (currentPage-1) * pageSize;
        params.put("startRecord", startIndex);
        params.put("pageSize", pageSize);
        return params;
    }
}
