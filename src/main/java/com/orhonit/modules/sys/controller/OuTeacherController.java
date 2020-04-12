package com.orhonit.modules.sys.controller;

import java.util.List;
import java.util.Map;

import com.orhonit.common.enums.ResultEnum;
import com.orhonit.common.exception.OlException;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dto.TeacherDTO;
import com.orhonit.modules.sys.service.OuTeacherService;
import com.orhonit.modules.sys.utils.ResultVOUtil;
import com.orhonit.modules.sys.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * 教师
 */
@RestController
@RequestMapping("/teacher")
@Slf4j
public class OuTeacherController {
    @Autowired
    private OuTeacherService ouTeacherService;

    @GetMapping("/list")
    public ResultVO<List<TeacherDTO>> list(@RequestParam Map<String, Object> params) {
//        if(null == params.get("currPage") || "".equals(params.get("currPage")) || Integer.parseInt(params.get("currPage").toString()) < 1) {
//            params.put("currentPage", 1);
//        } else {
//            params.put("currentPage", params.get("currPage"));
//        }
        List<TeacherDTO> list = ouTeacherService.selectByProperties(params);
        return ResultVOUtil.success(list);
    }

    @GetMapping("/listPage")
    public ResultVO<PageUtils> listPage(@RequestParam Map<String, Object> params) {
        if(null == params.get("currPage") || "".equals(params.get("currPage")) || Integer.parseInt(params.get("currPage").toString()) < 1) {
            params.put("currentPage", 1);
        } else {
            params.put("currentPage", params.get("currPage"));
        }
        PageUtils list = ouTeacherService.teacherQueryPage(params);
        return ResultVOUtil.success(list);
    }

    @GetMapping("/info")
    public ResultVO<TeacherDTO> info(@RequestParam(value="teacherId",required = false) String teacherId) {
        if(StringUtils.isEmpty(teacherId)) {
            log.error("【教师id不能为空】 teacherId为空");
            throw new OlException(ResultEnum.PARAM_NOT_NULL);
        }
        TeacherDTO entity = ouTeacherService.selectById(teacherId);
        return ResultVOUtil.success(entity);
    }

    /**
     * 添加
     * @param
     * @return
     */
    @PostMapping("/save")
    public ResultVO save(@RequestBody TeacherDTO teacherDTO){

        boolean flag = ouTeacherService.save(teacherDTO);
        if(flag) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.TEACHER_SAVE_ERROR.getCode(), ResultEnum.TEACHER_SAVE_ERROR.getMessage());
    }

    /**
     * 修改
     * @param
     * @return
     */
    @PutMapping("/update")
    public ResultVO update(@RequestBody TeacherDTO teacherDTO){
        boolean flag = ouTeacherService.update(teacherDTO);
        if(flag) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.TEACHER_UPD_ERROR.getCode(), ResultEnum.TEACHER_UPD_ERROR.getMessage());
    }

    /**
     * 修改
     * @param
     * @return
     */
    @DeleteMapping("/delete")
    public ResultVO delete(@RequestParam(value="teacherId",required = false) String teacherId){
        if(StringUtils.isEmpty(teacherId)) {
            log.error("【教师id不能为空】 teacherId为空");
            throw new OlException(ResultEnum.PARAM_NOT_NULL);
        }
        boolean flag = ouTeacherService.delete(teacherId);
        if(flag) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.TEACHER_DEL_ERROR.getCode(), ResultEnum.TEACHER_DEL_ERROR.getMessage());
    }

//    @GetMapping("/list")
//    public ResultVO<List<TeacherDTO>> list(@RequestParam(value="teacherId",required = false) String teacherId,
//                                           @RequestParam(value="teacherName",required = false) String teacherName,
//                                           @RequestParam(value="teacherIdentity",required = false) String teacherIdentity,
//                                           @RequestParam(value = "teacherSex", required = false) String teacherSex,
//                                           @RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("teacherId", teacherId);
//        params.put("teacherName", teacherName);
//        params.put("teacherIdentity", teacherIdentity);
//        params.put("teacherSex", teacherSex);
////        params.put("teacherAreaId", teacherAreaId);
////        params.put("teacherMajorId", teacherMajorId);
//        params.put("currentPage", currentPage < 1 ? 1 : currentPage);
//        List<TeacherDTO> list = ouTeacherService.selectByProperties(params);
//        return ResultVOUtil.success(list);
//    }

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:outeacher:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = ouTeacherService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{tId}")
//    @RequiresPermissions("generator:outeacher:info")
//    public R info(@PathVariable("tId") Integer tId){
//			OuTeacherEntity ouTeacher = ouTeacherService.selectById(tId);
//
//        return R.ok().put("ouTeacher", ouTeacher);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("generator:outeacher:save")
//    public R save(@RequestBody OuTeacherEntity ouTeacher){
//			ouTeacherService.insert(ouTeacher);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("generator:outeacher:update")
//    public R update(@RequestBody OuTeacherEntity ouTeacher){
//			ouTeacherService.updateById(ouTeacher);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:outeacher:delete")
//    public R delete(@RequestBody Integer[] tIds){
//			ouTeacherService.deleteBatchIds(Arrays.asList(tIds));
//
//        return R.ok();
//    }

}
