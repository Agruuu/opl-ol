package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.dto.AreaDTO;
import com.orhonit.modules.sys.service.UserAreaService;
import com.orhonit.modules.sys.utils.ResultVOUtil;
import com.orhonit.modules.sys.vo.ResultVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-21 14:29:50
 */
@RestController
@RequestMapping("/area")
public class UserAreaController {
    @Autowired
    private UserAreaService userAreaService;

    /**
     * 查询地区
     * @return
     */
    @GetMapping(value = "/list")
    public ResultVO<AreaDTO> list() {
        List<AreaDTO> list = this.userAreaService.list();
        return ResultVOUtil.success(list);
    }
}
