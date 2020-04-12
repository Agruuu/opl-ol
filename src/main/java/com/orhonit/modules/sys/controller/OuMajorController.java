package com.orhonit.modules.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orhonit.common.enums.ResultEnum;
import com.orhonit.modules.sys.dto.MajorDTO;
import com.orhonit.modules.sys.service.OuMajorService;
import com.orhonit.modules.sys.utils.PageList;
import com.orhonit.modules.sys.utils.ResultVOUtil;
import com.orhonit.modules.sys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 专业表
 */
@RestController
@RequestMapping("/major")
public class OuMajorController {
    @Autowired
    private OuMajorService ouMajorService;

    /**
     * 分页查询
     * @param majorTitle 标题
     * @param currentPage 当前页
     * @return
     */
    @GetMapping("/list")
    public ResultVO<List<MajorDTO>> list(@RequestParam(value="majorTitle",required = false) String majorTitle,
                                             @RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("majorTitle", majorTitle);
        params.put("currentPage", currentPage < 1 ? 1 : currentPage);
        List<MajorDTO> page = ouMajorService.findByProperties(params);
        return ResultVOUtil.success(page);
    }

    /**
     *  专业下拉框查询
     * @return
     */
    @GetMapping("/comboboxList")
    public ResultVO<List<MajorDTO>> comboboxList() {
        Map<String, Object> params = new HashMap<String, Object>();
        List<MajorDTO> page = ouMajorService.comboList();
        return ResultVOUtil.success(page);
    }


    @PostMapping("/save")
    public ResultVO save(@RequestBody MajorDTO majorDTO) {
        boolean flag = ouMajorService.save(majorDTO);
        if(flag) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.MAJOR_SAVE_ERROR.getCode(), ResultEnum.MAJOR_SAVE_ERROR.getMessage());
    }

    @PutMapping("/update")
    public ResultVO<MajorDTO> update(@RequestParam(value = "majorId", required = true) String majorId,
                                     @RequestParam(value = "majorTitle", required = true) String majorTitle) {
        MajorDTO majorDTO = new MajorDTO();
        majorDTO.setMajorId(Integer.parseInt(majorId));
        majorDTO.setMajorTitle(majorTitle);
        boolean flag = ouMajorService.update(majorDTO);
        if(flag) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.MAJOR_UPD_ERROR.getCode(), ResultEnum.MAJOR_UPD_ERROR.getMessage());
    }

    @DeleteMapping("/delete")
    public ResultVO<MajorDTO> delete(@RequestParam(value = "majorId", required = true) String majorId) {
        boolean flag = ouMajorService.delete(majorId);
        if(flag) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error(ResultEnum.MAJOR_UPD_ERROR.getCode(), ResultEnum.MAJOR_UPD_ERROR.getMessage());
    }

//    @PostMapping("/list")
//    public ResultVO<PageList<MajorDTO>> list(@RequestParam(value="majorTitle",required = false) String majorTitle,
//                                             @RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("majorTitle", majorTitle);
//        params.put("currentPage", currentPage < 1 ? 1 : currentPage);
//        PageList<MajorDTO> page = ouMajorService.findByProperties(params);
//        return ResultVOUtil.success(page);
//    }
//
//    /**
//     * 查找院校
//     * @param currentPage
//     * @return
//     */
//    @PostMapping("/department")
//    public ResultVO<List<MajorDTO>> getDepartmentList(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage) {
//        Map<String, Object> params = new HashMap<String, Object>();
////        params.put("areaId", areaId);
//        params.put("currentPage", currentPage < 1 ? 1 : currentPage);
////        params.put("majorSupperId", "0");
////        PageList<MajorDTO> page = ouMajorService.findParentMajorLis
//
//        List<MajorDTO> majorDTOList = ouMajorService.findMajorList(params); //findParentMajorList
//        return ResultVOUtil.success(majorDTOList);
//    }
//
//    /**
//     * 查找专业
//     * @param currentPage
//     * @return
//     */
//    @PostMapping("/major")
//    public ResultVO<List<MajorDTO>> getMajorFromDepart(@RequestParam(value="currentPage",defaultValue="1",required = false) Integer currentPage) {
//        Map<String, Object> params = new HashMap<String, Object>();
////        params.put("areaId", areaId);
//        params.put("currentPage", currentPage < 1 ? 1 : currentPage);
////        params.put("majorSupperId", departmentId);
////        params.put("majorSupperIdNot", "0");
//
//        List<MajorDTO> majorDTOList = ouMajorService.findMajorList(params); //findParentMajorList
//        return ResultVOUtil.success(majorDTOList);
//    }

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:oumajor:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = ouMajorService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{majorId}")
////    @RequiresPermissions("generator:oumajor:info")
//    public R info(@PathVariable("majorId") Integer majorId){
//			OuMajorEntity ouMajor = ouMajorService.selectById(majorId);
//
//        return R.ok().put("ouMajor", ouMajor);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("generator:oumajor:save")
//    public R save(@RequestBody OuMajorEntity ouMajor){
//			ouMajorService.insert(ouMajor);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody OuMajorEntity ouMajor){
//			ouMajorService.updateById(ouMajor);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:oumajor:delete")
//    public R delete(@RequestBody Integer[] majorIds){
//			ouMajorService.deleteBatchIds(Arrays.asList(majorIds));
//
//        return R.ok();
//    }

}
