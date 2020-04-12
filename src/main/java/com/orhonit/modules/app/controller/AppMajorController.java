package com.orhonit.modules.app.controller;

import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.sys.dto.MajorDTO;
import com.orhonit.modules.sys.service.OuMajorService;
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
public class AppMajorController {
    @Autowired
    private OuMajorService ouMajorService;

    /**
     *  专业下拉框查询
     * @return
     */
    @Login
    @GetMapping("/major/comboList")
    public ResultVO<List<MajorDTO>> comboList() {
        Map<String, Object> params = new HashMap<String, Object>();
        List<MajorDTO> page = ouMajorService.comboList();
        return ResultVOUtil.success(page);
    }
}
