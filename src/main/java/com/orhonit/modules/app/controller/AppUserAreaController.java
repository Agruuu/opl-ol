package com.orhonit.modules.app.controller;

import com.orhonit.modules.sys.dto.AreaDTO;
import com.orhonit.modules.sys.service.UserAreaService;
import com.orhonit.modules.sys.utils.ResultVOUtil;
import com.orhonit.modules.sys.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * app地区
 */
@RestController
@RequestMapping("/app")
public class AppUserAreaController {
    @Autowired
    private UserAreaService userAreaService;

    /**
     * 查询地区
     * @return
     */
    @GetMapping(value = "/area/list")
    public ResultVO<AreaDTO> list() {
        List<AreaDTO> list = this.userAreaService.list();
        return ResultVOUtil.success(list);
    }
}
