package com.orhonit.modules.app.controller;

import com.orhonit.common.enums.ResultEnum;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.sys.dto.CourseCommentDTO;
import com.orhonit.modules.sys.dto.CourseDTO;
import com.orhonit.modules.sys.dto.CourseForWeekDTO;
import com.orhonit.modules.sys.dto.SignupDTO;
import com.orhonit.modules.sys.service.OuCourseService;
import com.orhonit.modules.sys.utils.ResultVOUtil;
import com.orhonit.modules.sys.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课程信息
 */
@Slf4j
@RestController
@RequestMapping("/app")
public class AppCourseController {
    @Autowired
    private OuCourseService ouCourseService;

    /**
     * 查询当日课程
     * @return
     */
    @Login
    @GetMapping("course/courseForToday")
    public ResultVO<CourseForWeekDTO> selectCoursesForTomorrow(@RequestAttribute("userId") Integer userId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        CourseForWeekDTO list = ouCourseService.selectCoursesForToday(params);
        return ResultVOUtil.success(list);
    }

    /**
     * 查询上周，本周，下周课程
     * @param queryMode 查询方式(1 本周课程，2 上周课程，3 下周课程)
     * @return
     * //@RequestParam(value="token",required = false) String token,
     */
    @Login
    @GetMapping("course/courseForWeek")
    public ResultVO<List<CourseForWeekDTO>> coursesForWeek(@RequestParam(value="queryMode", defaultValue = "1", required = false) String queryMode,
                                                           @RequestAttribute("userId") Integer userId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        params.put("queryMode", queryMode);
        List<CourseForWeekDTO> list = ouCourseService.selectCoursesForWeek(params);
        return ResultVOUtil.success(list);
    }

    /**
     * 查询课程详情
     * @param courseId
     * @return
     */
    @Login
    @GetMapping("course/info/{courseId}")
    public ResultVO<List<CourseDTO>> courseInfo(@PathVariable("courseId") Integer courseId) {
        CourseDTO courseDTO = this.ouCourseService.selectByIdForApp(courseId);
        return ResultVOUtil.success(courseDTO);
    }

    /**
     * 查询课程(已报名和未报名课程)
     * @param userId
     * @return
     * queryMode 1 报名过的课程，2 未报名的课程
     */
    @Login
    @GetMapping("course/courseData")
    public ResultVO<List<CourseDTO>> courseData(@RequestParam Map<String, Object> params,
                                               @RequestAttribute("userId") Integer userId) {
        params.put("userId", userId);
        if(null == params.get("currentPage") || "".equals(params.get("currentPage")) || Integer.parseInt(params.get("currentPage").toString()) < 1) {
            params.put("currentPage", 1);
        }
        List<CourseDTO> list;
        if(null != params.get("queryMode") && params.get("queryMode").equals("1")) {
            list = ouCourseService.selectAlreadySignup(params);
        } else {
            list = ouCourseService.selectDidntSignup(params);
        }
        return ResultVOUtil.success(list);
    }

    /**
     * 查询精品课程
     */
    @Login
    @GetMapping("course/courseCompetitive")
    public ResultVO<List<CourseDTO>> courseCompetitive(@RequestParam Map<String, Object> params) {
        if(null == params.get("currentPage") || "".equals(params.get("currentPage")) || Integer.parseInt(params.get("currentPage").toString()) < 1) {
            params.put("currentPage", 1);
        }
        params.put("courseCompetitive", "1");
        List<CourseDTO> list = this.ouCourseService.selectByProperties(params);
        return ResultVOUtil.success(list);
    }

    /**
     * 课程报名
     * @return
     */
    @Login
    @PostMapping("course/courseSignup")
    public ResultVO courseSignup(@RequestParam(value="courseId",required = true) String courseId,
                                                  @RequestAttribute("userId") Integer userId) {
        Integer result = this.ouCourseService.courseSignup(Integer.parseInt(courseId), userId);
        if(result > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.COURSE_SIGNUP_ERROR.getCode(), ResultEnum.COURSE_SIGNUP_ERROR.getMessage());
    }

    /**
     * 课程报名情况
     * @return
     */
    @Login
    @GetMapping("course/courseSignupList")
    public ResultVO<List<SignupDTO>> signupCountList(@RequestParam(value="courseId",required = true) String courseId,
                                                     @RequestParam(value="currentPage", defaultValue="1", required = false) Integer currentPage) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("signCourseId", courseId);
        params.put("currentPage", currentPage < 1 ? 1 : currentPage);
        List<SignupDTO> list = ouCourseService.signupCountList(params);
        return ResultVOUtil.success(list);
    }

    /**
     * 课程评价
     * @return
     */
    @Login
    @PostMapping("course/courseComment")
    public ResultVO courseComment(@RequestBody CourseCommentDTO courseCommentDTO,
                                  @RequestAttribute("userId") Integer userId) {
        courseCommentDTO.setCommUserId(userId);
        Integer result = this.ouCourseService.addCourseComment(courseCommentDTO);

        if(result > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.COURSE_COMMENT_ADD_ERROR.getCode(), ResultEnum.COURSE_COMMENT_ADD_ERROR.getMessage());
    }

















//    /**
//     * 查询课程(已报名和未报名课程)
//     * @param queryMode 1 报名过的课程，2 未报名的课程
//     * @param userId
//     * @return
//     */
//    @Login
//    @GetMapping("course/courseData")
//    public ResultVO<List<CourseDTO>> courseData(@RequestParam(value="queryMode", defaultValue = "1", required = false) String queryMode,
//                                                @RequestParam(value="currentPage", defaultValue="1", required = false) Integer currentPage,
//                                                @RequestAttribute("userId") Integer userId) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("userId", userId);
//        params.put("currentPage", currentPage < 1 ? 1 : currentPage);
//        List<CourseDTO> list;
//        if(queryMode.equals("1")) {
//            list = ouCourseService.selectAlreadySignup(params);
//        } else {
//            list = ouCourseService.selectDidntSignup(params);
//        }
//        return ResultVOUtil.success(list);
//    }

//    @Login
//    @GetMapping("course/list")
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
}
