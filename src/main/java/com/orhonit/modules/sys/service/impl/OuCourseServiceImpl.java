package com.orhonit.modules.sys.service.impl;

import com.orhonit.common.enums.ResultEnum;
import com.orhonit.common.exception.OlException;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.OuCourseCommentDao;
import com.orhonit.modules.sys.dao.OuCourseScheduleDao;
import com.orhonit.modules.sys.dao.OuCourseDao;
import com.orhonit.modules.sys.dao.OuSignupDao;
import com.orhonit.modules.sys.dto.*;
import com.orhonit.modules.sys.entity.OuCourseCommentEntity;
import com.orhonit.modules.sys.entity.OuCourseScheduleEntity;
import com.orhonit.modules.sys.entity.OuCourseEntity;
import com.orhonit.modules.sys.entity.OuSignupEntity;
import com.orhonit.modules.sys.service.OuCourseService;
import com.orhonit.modules.sys.utils.PageParamsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;


@Service("ouCoursesService")
@Slf4j
public class OuCourseServiceImpl extends ServiceImpl<OuCourseDao, OuCourseEntity> implements OuCourseService {

    @Autowired
    private OuCourseDao ouCourseDao;
    @Autowired
    private OuCourseScheduleDao ouCourseScheduleDao;
    @Autowired
    private OuSignupDao ouSignupDao;
    @Autowired
    private OuCourseCommentDao ouCourseCommentDao;

    /**
     * 按条件查询
     * @param params
     * @return
     */
    @Override
    public PageUtils courseQueryPage(Map<String, Object> params) {
        params = PageParamsUtil.getLimitWeb(params);
        List<CourseDTO> list = this.ouCourseDao.selectByProperties(params);
        Integer count = this.ouCourseDao.selectByPropertiesCount(params);
        Integer pageSize = Integer.parseInt(params.get("length").toString());
        Integer currPage = Integer.parseInt(params.get("currentPage").toString());
        PageUtils pageUtils = new PageUtils(list, count, pageSize, currPage);
        return pageUtils;
    }

    /**
     * 按条件查询
     * @param params
     * @return
     */
    @Override
    public List<CourseDTO> selectByProperties(Map<String, Object> params) {
        params = PageParamsUtil.getLimit(params);
        List<CourseDTO> list = this.ouCourseDao.selectByProperties(params);
        return list;
    }

    /**
     * 按条件查询
     * @param params
     * @return
     */
    @Override
    public List<CourseDTO> selectByPropertiesWeb(Map<String, Object> params) {
        params = PageParamsUtil.getLimitWeb(params);
        List<CourseDTO> list = this.ouCourseDao.selectByProperties(params);
        return list;
    }

    /**
     * 查询单个对象
     * @return
     */
    @Override
    public CourseDTO selectById(Integer courseId) {
        CourseDTO info = this.ouCourseDao.selectCourseInfo(courseId);
        if(null != info) {
            Map<String, Object> params = new HashMap<>();
            params.put("courseId", info.getCourseId());
            List<CourseScheduleDTO> list = this.ouCourseScheduleDao.selectByProperties(params);
            info.setCourseTime(list);
        }
        return info;
    }

    /**
     * 查询单个对象
     * @return
     */
    @Override
    public CourseDTO selectByIdForApp(Integer courseId) {
        CourseDTO info = this.ouCourseDao.selectCourseInfo(courseId);
        if(null != info) {
            Map<String, Object> params = new HashMap<>();
            params.put("courseId", info.getCourseId());
            List<CourseScheduleDTO> list = this.ouCourseScheduleDao.selectByProperties(params);
            info.setCourseTime(list);
            List<CourseCommentDTO> commentList = this.ouCourseCommentDao.list(params);
            for (CourseCommentDTO item : commentList) {
                if (null != item.getCommPictureUrls() && !"".equals(item.getCommPictureUrls())) {
                    item.setCommPictureUrl(item.getCommPictureUrls().split(","));
                }
            }
            info.setCourseComment(commentList);
        }
        return info;
    }

    /**
     * 查询课程时间
     * @param params
     * @return
     */
    @Override
    public List<CourseScheduleDTO> courseTimeList(Map<String, Object> params) {
        params = PageParamsUtil.getLimit(params);
        List<CourseScheduleDTO> list = this.ouCourseScheduleDao.list(params);
        return list;
    }

    /**
     * 查询课程时间
     * @param params
     * @return
     */
    @Override
    public PageUtils courseTimeListPage(Map<String, Object> params) {
        params = PageParamsUtil.getLimitWeb(params);
        List<CourseScheduleDTO> list = this.ouCourseScheduleDao.list(params);
        Integer count = this.ouCourseScheduleDao.listCount(params);
        Integer pageSize = Integer.parseInt(params.get("length").toString());
        Integer currPage = Integer.parseInt(params.get("currentPage").toString());
        PageUtils pageUtils = new PageUtils(list, count, pageSize, currPage);
        return pageUtils;
    }

    /**
     * 查询当天课程
     * @param params
     * @return
     */
    @Override
    public CourseForWeekDTO selectCoursesForToday(Map<String, Object> params) {
        // 设置当天日期 查询当天课程
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        params.put("courseDate", sdf.format(new Date()));
        List<CourseScheduleDTO> list = ouCourseScheduleDao.selectByProperties(params);
        CourseForWeekDTO dto = getCoursesForToday(list);
        return dto;
    }

    /**
     * 查询上周，本周，下周课程
     */
    @Override
    public List<CourseForWeekDTO> selectCoursesForWeek(Map<String, Object> params) {
        // 查询课程时间表
        List<CourseScheduleDTO> list = ouCourseScheduleDao.selectByProperties(params);
        CourseForWeekDTO dto = getCoursesForToday(list);
        List<CourseForWeekDTO> courseForWeekDTOList = getCourseForWeek(list);
        return courseForWeekDTOList;
    }

    /**
     * 查询课程（用户报名）
     * @param params
     * @return
     */
    @Override
    public List<CourseDTO> selectAlreadySignup(Map<String, Object> params) {
        params = PageParamsUtil.getLimit(params);
        List<CourseDTO> list = this.ouCourseDao.selectAlreadySignup(params);
        return list;
    }

    /**
     * 查询课程（用户未报名）
     * @param params
     * @return
     */
    @Override
    public List<CourseDTO> selectDidntSignup(Map<String, Object> params) {
        params = PageParamsUtil.getLimit(params);
        String userId = params.get("userId").toString();
        String signCourseIds = this.ouSignupDao.userIsSign(userId);
        if(null == signCourseIds || StringUtils.isEmpty(signCourseIds)) {
            params.put("signCourseId", "");
        } else {
            params.put("signCourseId", signCourseIds);
        }
        List<CourseDTO> list = this.ouCourseDao.selectDidntSignup(params);
        return list;
    }

    /**
     * 课程报名
     * @param courseId
     * @return
     */
    @Override
    public Integer courseSignup(Integer courseId, Integer userId) {
        OuSignupEntity entity = new OuSignupEntity();
        entity.setSignUserId(userId);
        entity.setSignCourseId(courseId);
        entity.setSignDate(new Date());
        Integer result = this.ouSignupDao.insert(entity);
        return result;
    }

    /**
     * 课程总报名人数
     */
    @Override
    public Integer signupCount(Map<String, Object> params) {
        Integer count = this.ouSignupDao.signupCount(params);
        return count;
    }

    /**
     * 课程报名情况
     */
    @Override
    public List<SignupDTO> signupCountList(Map<String, Object> params) {
        params = PageParamsUtil.getLimit(params);
        List<SignupDTO> list = this.ouSignupDao.signupCountList(params);
        return list;
    }

    /**
     * 课程评论
     * @param courseCommentDTO
     * @return
     */
    @Override
    public Integer addCourseComment(CourseCommentDTO courseCommentDTO) {
        OuCourseCommentEntity entity = new OuCourseCommentEntity();
        BeanUtils.copyProperties(courseCommentDTO, entity);
        entity.setCommIsUse("Y");
        entity.setCommDate(new Date());
        if(null != courseCommentDTO.getCommPictureUrl() && courseCommentDTO.getCommPictureUrl().length > 0) {
            String picUrl = ArrayUtils.toString(courseCommentDTO.getCommPictureUrl());
            entity.setCommPictureUrl(picUrl.substring(1, picUrl.length() - 1));
        }

        Integer result = this.ouCourseCommentDao.insert(entity);
        return result;
    }

    /**
     * 添加课程
     * @param coursesDTO
     * @return
     */
    @Override
    @Transactional
    public Integer saveCourse(CourseDTO coursesDTO) {
        OuCourseEntity entity = new OuCourseEntity();
        Integer courseResult = saveCourseDTO(coursesDTO);
        if(courseResult < 1) {
//            return ResultVOUtil.error(ResultEnum.COURSE_SAVE_ERROR.getCode(), ResultEnum.COURSE_SAVE_ERROR.getMessage());
            log.error("【添加课程】 添加课程信息错误，={}", coursesDTO.getCourseName());
            throw new OlException(ResultEnum.COURSE_SAVE_ERROR);
        }
        try {
            Integer courseTimeResult = saveCourseTimeList(coursesDTO);
            if(courseTimeResult < 1) {
                log.error("【添加课程】 添加课程时间错误，={}", coursesDTO.getCourseName());
                throw new OlException(ResultEnum.COURSE_TIME_SAVE_ERROR);
            }
        } catch(Exception ex) {
            log.error("【添加课程】 添加课程时间错误，={}", coursesDTO.getCourseName());
            throw new OlException(ResultEnum.COURSE_TIME_SAVE_ERROR);
        }
        return 1;
    }

    /**
     * 添加课程时间
     * @return
     */
    @Override
    public Integer saveCourseTime(OuCourseScheduleEntity ouCourseScheduleEntity) {
        Integer result = this.ouCourseScheduleDao.insert(ouCourseScheduleEntity);
        return result;
    }

    /**
     * 修改课程
     * @param courseDTO
     * @return
     */
    @Override
    public Integer updateCourse(CourseDTO courseDTO) {
//        this.ouCourseScheduleDao.dele
        try {
            this.ouCourseScheduleDao.deleteByCourseId(courseDTO.getCourseId());
            //if(deleteResult < 1) {
            //    log.error("【修改课程】 修改课程错误，={}", courseDTO.getCourseName());
            //    throw new OlException(ResultEnum.COURSE_TIME_UPDATE_ERROR);
            //}
            Integer courseTimeResult = saveCourseTimeList(courseDTO);
            if(courseTimeResult < 1) {
                log.error("【修改课程】 添加课程时间错误，={}", courseDTO.getCourseName());
                throw new OlException(ResultEnum.COURSE_TIME_UPDATE_ERROR);
            }
        } catch(Exception ex) {
            log.error("【修改课程】 修改课程时间错误，={}", courseDTO.getCourseName());
            throw new OlException(ResultEnum.COURSE_TIME_UPDATE_ERROR);
        }
//        Integer result = this.ouCourseDao.updateById(entity);
        OuCourseEntity entity = new OuCourseEntity();
        BeanUtils.copyProperties(courseDTO, entity);
        entity.setCourseIsUse("Y");
        if(null == courseDTO.getCoursePictureUrl() || StringUtils.isEmpty(courseDTO.getCoursePictureUrl())) {
            entity.setCoursePictureUrl(" ");
        }
        Integer result = this.ouCourseDao.updateById(entity);
        return  result;
    }

    /**
     * 修改课程
     * @param entity
     * @return
     */
    @Override
    public Integer updateCourseTime(OuCourseScheduleEntity entity) {
        Integer result = this.ouCourseScheduleDao.updateById(entity);
        return  result;
    }

    /**
     * 删除课程
     * @return
     */
    @Transactional
    @Override
    public Integer deleteCourse(Integer[] ids) {
        List<OuCourseEntity> list = this.ouCourseDao.selectBatchIds(Arrays.asList(ids));
        Map<String, Object> params = new HashMap<>();
        Integer result = 0;
        Integer sum = 0;
        for(OuCourseEntity item : list) {
            // 先删除课程下面的时间信息
            params.put("ct_course_id", item.getCourseId());
            List<OuCourseScheduleEntity> scheduleList = this.ouCourseScheduleDao.selectByMap(params);
            for(OuCourseScheduleEntity schedule : scheduleList) {
                schedule.setCtIsUse("D");
                result = result + this.ouCourseScheduleDao.updateById(schedule);
                sum++;
            }

            // 删除课程
            item.setCourseIsUse("D");
            result = result + this.ouCourseDao.updateById(item);
            sum++;
        }
        return sum - result;
    }

    /**
     * 删除课程时间信息
     * @return
     */
    @Transactional
    @Override
    public Integer deleteCourseTime(Integer[] ids) {
//        Integer result = this.ouCoursesDao.updateById(entity);
//        return  false;
//        Integer result = this.ouCourseScheduleDao.deleteBatchIds(Arrays.asList(ids));
//        if(result < 1) {
//            log.error("【删除课程时间】 删除课程错误，courseIds = {}", ids);
//            throw new OlException(ResultEnum.COURSE_TIME_DELETE_ERROR);
//        }
//        return  result;
        Integer result = 0;
        List<OuCourseScheduleEntity> list = this.ouCourseScheduleDao.selectBatchIds(Arrays.asList(ids));
        for(OuCourseScheduleEntity item : list) {
            item.setCtIsUse("D");
            result = result + this.ouCourseScheduleDao.updateById(item);
        }
        return ids.length - result;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        params.put("courseSignOpen", "Y");
        params.put("courseIsUse", "Y");
        Page<OuCourseEntity> page = this.selectPage(
                new Query<OuCourseEntity>(params).getPage(),
                new EntityWrapper<OuCourseEntity>()
        );

        return new PageUtils(page);
    }

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        Integer newId = Integer.parseInt((String) params.get("newId"));
//        int currPage = 1;
//        int limit = 10;
//        if(params.get("page") != null){
//            currPage = Integer.parseInt((String)params.get("page"));
//        }
//        if(params.get("limit") != null){
//            limit = Integer.parseInt((String)params.get("limit"));
//        }
//        Page<NewsCommentEntity> page = new Page<>(currPage, limit);
//        int beginLimit = (currPage-1)*limit;
//        page.setRecords(newsCommentDao.getNewsCommentByPage(newId,beginLimit,limit));
//        page.setTotal(this.selectCount(new EntityWrapper<NewsCommentEntity>().where("new_id="+newId)));
//        return new PageUtils(page);
//    }

    /**
     * 添加课程
     * @param coursesDTO
     * @return
     */
    private Integer saveCourseDTO(CourseDTO coursesDTO) {
        OuCourseEntity entity = new OuCourseEntity();
        BeanUtils.copyProperties(coursesDTO, entity);
        entity.setCourseIsUse("Y");
//        entity.setCreateTime(new Date());
        Integer result = this.ouCourseDao.insert(entity);
        entity = this.ouCourseDao.selectOne(entity);
        coursesDTO.setCourseId(entity.getCourseId());
        return result;
    }

    /**
     * 添加课程时间信息
     * @param coursesDTO
     * @return
     */
    @Transactional
    private Integer saveCourseTimeList(CourseDTO coursesDTO) throws Exception {
        List<CourseScheduleDTO> courseScheduleDTOList = coursesDTO.getCourseTime();
        List<CourseScheduleDTO> list = new ArrayList<>();

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(CourseScheduleDTO item : courseScheduleDTOList) {
            if(null != coursesDTO.getCourseId())
                item.setCtCourseId(coursesDTO.getCourseId());
            if(null != coursesDTO.getCourseTeacherId())
                item.setCtTeacherId(coursesDTO.getCourseTeacherId());
            item.setCtIsUse("Y");
//            item.setCtCourseDate(sdf.parse(item.getCtCourseDateStr()));
            list.add(item);
        }
        Integer result = this.ouCourseScheduleDao.batchInsert(list);
        return result;
    }

    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String string = "2016-10-24";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            System.out.println(sdf.parse(string));

        }catch (Exception ex) {

        }
//        System.out.println(sdf.parse(strings).toString());
    }

    /**
     * 查询当天课程
     * @param list
     * @return
     */
    private CourseForWeekDTO getCoursesForToday(List<CourseScheduleDTO> list) {
        CourseForWeekDTO dto = null;
        for (CourseScheduleDTO item : list) {
            if (null == dto) {
                dto = new CourseForWeekDTO();
            }
            if (item.getCtPeriod().equals("AM")) {
                dto.getMorningCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
            } else {
                dto.getAfternoonCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
            }
            //dto.setDayOfWeek(item.getCtDayOfWeek());
        }

        return dto;
    }

    private List<CourseForWeekDTO> getCourseForWeek(List<CourseScheduleDTO> list) {
        List<CourseForWeekDTO> courseForWeekDTOS = new ArrayList<>();
        CourseForWeekDTO[] courseDTOS = new CourseForWeekDTO[7];
        CourseForWeekDTO dto = null;
        for (CourseScheduleDTO item : list) {
            if(item.getCtDayOfWeek() == 1) {
                if(null == courseDTOS[0]) {
                    dto = new CourseForWeekDTO();
                } else {
                    dto = courseDTOS[0];
                }
                if(item.getCtPeriod().equals("AM")) {
                    dto.getMorningCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                } else {
                    dto.getAfternoonCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                }
                dto.setDayOfWeek(item.getCtDayOfWeek());
                courseDTOS[0] = dto;
                dto = null;
            } else if(item.getCtDayOfWeek() == 2) {
                if(null == courseDTOS[1]) {
                    dto = new CourseForWeekDTO();
                } else {
                    dto = courseDTOS[1];
                }
                if(item.getCtPeriod().equals("AM")) {
                    dto.getMorningCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                } else {
                    dto.getAfternoonCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                }
                dto.setDayOfWeek(item.getCtDayOfWeek());
                courseDTOS[1] = dto;
                dto = null;
            } else if(item.getCtDayOfWeek() == 3) {
                if(null == courseDTOS[2]) {
                    dto = new CourseForWeekDTO();
                } else {
                    dto = courseDTOS[2];
                }
                if(item.getCtPeriod().equals("AM")) {
                    dto.getMorningCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                } else {
                    dto.getAfternoonCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                }
                dto.setDayOfWeek(item.getCtDayOfWeek());
                courseDTOS[2] = dto;
                dto = null;
            } else if(item.getCtDayOfWeek() == 4) {
                if(null == courseDTOS[3]) {
                    dto = new CourseForWeekDTO();
                } else {
                    dto = courseDTOS[3];
                }
                if(item.getCtPeriod().equals("AM")) {
                    dto.getMorningCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                } else {
                    dto.getAfternoonCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                }
                dto.setDayOfWeek(item.getCtDayOfWeek());
                courseDTOS[3] = dto;
                dto = null;
            } else if(item.getCtDayOfWeek() == 5) {
                if(null == courseDTOS[4]) {
                    dto = new CourseForWeekDTO();
                } else {
                    dto = courseDTOS[4];
                }
                if(item.getCtPeriod().equals("AM")) {
                    dto.getMorningCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                } else {
                    dto.getAfternoonCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                }
                dto.setDayOfWeek(item.getCtDayOfWeek());
                courseDTOS[4] = dto;
                dto = null;
            } else if(item.getCtDayOfWeek() == 6) {
                if(null == courseDTOS[5]) {
                    dto = new CourseForWeekDTO();
                } else {
                    dto = courseDTOS[5];
                }
                if(item.getCtPeriod().equals("AM")) {
                    dto.getMorningCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                } else {
                    dto.getAfternoonCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                }
                dto.setDayOfWeek(item.getCtDayOfWeek());
                courseDTOS[5] = dto;
                dto = null;
            } else if(item.getCtDayOfWeek() == 7) {
                if(null == courseDTOS[6]) {
                    dto = new CourseForWeekDTO();
                } else {
                    dto = courseDTOS[6];
                }
                if(item.getCtPeriod().equals("AM")) {
                    dto.getMorningCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                } else {
                    dto.getAfternoonCourse().add(item.getCtCourseName() + ": " + item.getCtStartTime() + "-" + item.getCtEndTime());
                }
                dto.setDayOfWeek(item.getCtDayOfWeek());
                courseDTOS[6] = dto;
                dto = null;
            }
        }
        courseForWeekDTOS = Arrays.asList(courseDTOS);
        List<CourseForWeekDTO> weekDTOList = new ArrayList<>();
        for (CourseForWeekDTO item : courseForWeekDTOS) {
            if(null != item) {
                weekDTOList.add(item);
            }
        }

        return weekDTOList;
    }

//    private CourseForWeekDTO getCoursesForToday(List<CourseDTO> list) {
//        List<CourseForWeekDTO> courseForWeekDTOS = new ArrayList<>();
//        CourseForWeekDTO dto = null;
//        for (CourseDTO item : list) {
//            if (null == dto) {
//                dto = new CourseForWeekDTO();
//            }
//            if (item.getPeriod().equals("AM")) {
//                dto.getMorningData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//            } else {
//                dto.getAfternoonData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//            }
//            dto.setWeekday(item.getWeekday());
//        }
//
//        return dto;
//    }

//    private List<CourseForWeekDTO> getCourseForWeek(List<CourseDTO> list) {
//        List<CourseForWeekDTO> courseForWeekDTOS = new ArrayList<>();
//        CourseForWeekDTO[] courseDTOS = new CourseForWeekDTO[7];
//        CourseForWeekDTO dto = null;
//        for (CourseDTO item : list) {
//            if(item.getWeekday() == 1) {
//                if(null == courseDTOS[0]) {
//                    dto = new CourseForWeekDTO();
//                } else {
//                    dto = courseDTOS[0];
//                }
//                if(item.getPeriod().equals("AM")) {
//                    dto.getMorningData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                } else {
//                    dto.getAfternoonData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                }
//                dto.setWeekday(item.getWeekday());
//                courseDTOS[0] = dto;
//                dto = null;
//            } else if(item.getWeekday() == 2) {
//                if(null == courseDTOS[1]) {
//                    dto = new CourseForWeekDTO();
//                } else {
//                    dto = courseDTOS[1];
//                }
//                if(item.getPeriod().equals("AM")) {
//                    dto.getMorningData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                } else {
//                    dto.getAfternoonData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                }
//                dto.setWeekday(item.getWeekday());
//                courseDTOS[1] = dto;
//                dto = null;
//            } else if(item.getWeekday() == 3) {
//                if(null == courseDTOS[2]) {
//                    dto = new CourseForWeekDTO();
//                } else {
//                    dto = courseDTOS[2];
//                }
//                if(item.getPeriod().equals("AM")) {
//                    dto.getMorningData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                } else {
//                    dto.getAfternoonData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                }
//                dto.setWeekday(item.getWeekday());
//                courseDTOS[2] = dto;
//                dto = null;
//            } else if(item.getWeekday() == 4) {
//                if(null == courseDTOS[3]) {
//                    dto = new CourseForWeekDTO();
//                } else {
//                    dto = courseDTOS[3];
//                }
//                if(item.getPeriod().equals("AM")) {
//                    dto.getMorningData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                } else {
//                    dto.getAfternoonData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                }
//                dto.setWeekday(item.getWeekday());
//                courseDTOS[3] = dto;
//                dto = null;
//            } else if(item.getWeekday() == 5) {
//                if(null == courseDTOS[4]) {
//                    dto = new CourseForWeekDTO();
//                } else {
//                    dto = courseDTOS[4];
//                }
//                if(item.getPeriod().equals("AM")) {
//                    dto.getMorningData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                } else {
//                    dto.getAfternoonData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                }
//                dto.setWeekday(item.getWeekday());
//                courseDTOS[4] = dto;
//                dto = null;
//            } else if(item.getWeekday() == 6) {
//                if(null == courseDTOS[5]) {
//                    dto = new CourseForWeekDTO();
//                } else {
//                    dto = courseDTOS[5];
//                }
//                if(item.getPeriod().equals("AM")) {
//                    dto.getMorningData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                } else {
//                    dto.getAfternoonData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                }
//                dto.setWeekday(item.getWeekday());
//                courseDTOS[5] = dto;
//                dto = null;
//            } else if(item.getWeekday() == 7) {
//                if(null == courseDTOS[6]) {
//                    dto = new CourseForWeekDTO();
//                } else {
//                    dto = courseDTOS[6];
//                }
//                if(item.getPeriod().equals("AM")) {
//                    dto.getMorningData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                } else {
//                    dto.getAfternoonData().add(item.getCourseName() + ": " + item.getCourseBeginTime() + "-" + item.getCourseEndTime());
//                }
//                dto.setWeekday(item.getWeekday());
//                courseDTOS[6] = dto;
//                dto = null;
//            }
//        }
//        courseForWeekDTOS = Arrays.asList(courseDTOS);
//        List<CourseForWeekDTO> weekDTOList = new ArrayList<>();
//        for (CourseForWeekDTO item : courseForWeekDTOS) {
//            if(null != item) {
//                weekDTOList.add(item);
//            }
//        }
//
//        return weekDTOList;
//    }
}
