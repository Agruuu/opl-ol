package com.orhonit.modules.sys.controller;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.orhonit.common.enums.ResultEnum;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.sys.dto.CourseDTO;
import com.orhonit.modules.sys.dto.CourseScheduleDTO;
import com.orhonit.modules.sys.entity.NewsCommentEntity;
import com.orhonit.modules.sys.entity.OuCourseScheduleEntity;
import com.orhonit.modules.sys.entity.OuCourseEntity;
import com.orhonit.modules.sys.service.OuCourseService;
import com.orhonit.modules.sys.utils.ResultVOUtil;
import com.orhonit.modules.sys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 课程信息
 */
@RestController
@RequestMapping("/course")
public class OuCourseController {
    @Autowired
    private OuCourseService ouCourseService;

    @GetMapping("/list")
    public ResultVO<List<CourseDTO>> list(@RequestParam Map<String, Object> params) {

        if(null == params.get("currPage") || "".equals(params.get("currPage")) || Integer.parseInt(params.get("currPage").toString()) < 1) {
            params.put("currentPage", 1);
        } else {
            params.put("currentPage", params.get("currPage"));
        }
        List<CourseDTO> list = this.ouCourseService.selectByPropertiesWeb(params);
        return ResultVOUtil.success(list);
    }

    @GetMapping("/listPage")
    public ResultVO<PageUtils> listPage(@RequestParam Map<String, Object> params){
        if(null == params.get("currPage") || "".equals(params.get("currPage")) || Integer.parseInt(params.get("currPage").toString()) < 1) {
            params.put("currentPage", 1);
        } else {
            params.put("currentPage", params.get("currPage"));
        }
        PageUtils pageUtils = this.ouCourseService.courseQueryPage(params);
        return ResultVOUtil.success(pageUtils);
    }

    @GetMapping("/courseTimeList")
    public ResultVO<List<CourseDTO>> courseTimeList(@RequestParam Map<String, Object> params) {

        if(null == params.get("currPage") || "".equals(params.get("currPage")) || Integer.parseInt(params.get("currPage").toString()) < 1) {
            params.put("currentPage", 1);
        } else {
            params.put("currentPage", params.get("currPage"));
        }
        List<CourseScheduleDTO> list = this.ouCourseService.courseTimeList(params);
        return ResultVOUtil.success(list);
    }

    @GetMapping("/courseTimeListPage")
    public ResultVO<PageUtils> courseTimeListPage(@RequestParam Map<String, Object> params) {

        if(null == params.get("currPage") || "".equals(params.get("currPage")) || Integer.parseInt(params.get("currPage").toString()) < 1) {
            params.put("currentPage", 1);
        } else {
            params.put("currentPage", params.get("currPage"));
        }
        PageUtils pageUtils = this.ouCourseService.courseTimeListPage(params);
        return ResultVOUtil.success(pageUtils);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{courseId}")
//    @RequiresPermissions("generator:oucourse:info")
    public ResultVO<CourseDTO> info(@PathVariable("courseId") Integer courseId){
		CourseDTO courseDTO = this.ouCourseService.selectById(courseId);

        return ResultVOUtil.success(courseDTO);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
//    @RequiresPermissions("generator:oucourse:save")
    public ResultVO save(@RequestBody CourseDTO courseDTO){
		Integer result = this.ouCourseService.saveCourse(courseDTO);

		if(result > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.COURSE_SAVE_ERROR.getCode(), ResultEnum.COURSE_SAVE_ERROR.getMessage());
    }

    /**
     * 保存
     */
    @PostMapping("/saveCourseTime")
//    @RequiresPermissions("generator:oucourse:save")
    public ResultVO saveCourseTime(@RequestBody OuCourseScheduleEntity ouCourseScheduleEntity){
        Integer result = this.ouCourseService.saveCourseTime(ouCourseScheduleEntity);

        if(result > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.COURSE_TIME_DELETE_ERROR.getCode(), ResultEnum.COURSE_TIME_SAVE_ERROR.getMessage());
    }

    /**
     * 修改
     */
    @PutMapping("/updateCourse")
//    @RequiresPermissions("generator:oucourse:update")
    public ResultVO update(@RequestBody CourseDTO courseDTO){
		Integer result = this.ouCourseService.updateCourse(courseDTO);

        if(result > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.COURSE_UPDATE_ERROR.getCode(), ResultEnum.COURSE_UPDATE_ERROR.getMessage());
    }

    /**
     * 修改
     */
    @PutMapping("/updateCourseTime")
//    @RequiresPermissions("generator:oucourse:update")
    public ResultVO updateCourseTime(@RequestBody OuCourseScheduleEntity ouCourseScheduleEntity){
        Integer result = this.ouCourseService.updateCourseTime(ouCourseScheduleEntity);

        if(result > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.COURSE_TIME_UPDATE_ERROR.getCode(), ResultEnum.COURSE_TIME_UPDATE_ERROR.getMessage());
    }

    /**
     * 删除
     * (value="majorId",required = false)
     */
    @DeleteMapping("/deleteCourse")
//    @RequiresPermissions("generator:oucourse:delete")
    public ResultVO delete(@RequestParam(value="courseIds", defaultValue = "1", required = false) Integer[] courseIds){
        if(null == courseIds || courseIds.length < 1) {
            return ResultVOUtil.error(ResultEnum.PARAM_NOT_NULL.getCode(), ResultEnum.PARAM_NOT_NULL.getMessage());
        }

        Integer result = this.ouCourseService.deleteCourse(courseIds);
        if(result == 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.COURSE_DELETE_ERROR.getCode(), ResultEnum.COURSE_DELETE_ERROR.getMessage());
    }

    @DeleteMapping("/deleteCourseTime")
//    @RequiresPermissions("generator:oucourseschedule:delete")
    public ResultVO deleteCourseTime(@RequestParam(value="ctIds", defaultValue = "1", required = false) Integer[] ctIds){
        if(null == ctIds || ctIds.length < 1) {
            return ResultVOUtil.error(ResultEnum.PARAM_NOT_NULL.getCode(), ResultEnum.PARAM_NOT_NULL.getMessage());
        }

        Integer result = this.ouCourseService.deleteCourseTime(ctIds);
        if(result == 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.COURSE_TIME_DELETE_ERROR.getCode(), ResultEnum.COURSE_TIME_DELETE_ERROR.getMessage());
    }

//    @DeleteMapping("/deleteCourse")
////    @RequiresPermissions("generator:oucourse:delete")
//    public R delete(@RequestBody Integer[] courseIds){
//        ouCoursesService.deleteBatchIds(Arrays.asList(courseIds));
//
//        return R.ok();
//    }

//    /**
//     * 列表
//     */
//    @GetMapping("/list")
//    public ResultVO<List<CourseDTO>> list(@RequestParam(value="majorId",required = false) String courseMajorId,
//                                          @RequestParam(value="areaId",required = false) String courseAreaId,
//                                          @RequestParam(value="teacherId",required = false) String teacherId,
//                                          @RequestParam(value="courseName",required = false) String courseName,
//                                          @RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("courseMajorId", courseMajorId);
//        params.put("courseAreaId", courseAreaId);
//        params.put("courseTeacherId", teacherId);
//        params.put("courseName", courseName);
//        params.put("currentPage", currentPage < 1 ? 1 : currentPage);
//        List<CourseDTO> list = ouCourseService.selectByProperties(params);
//        return ResultVOUtil.success(list);
//    }

//    @RequestMapping("/list")
////    @RequiresPermissions("generator:oucourse:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = ouCoursesService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
}
