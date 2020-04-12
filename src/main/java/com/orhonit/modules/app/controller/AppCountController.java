package com.orhonit.modules.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.sys.service.MeetingService;

@RestController
@RequestMapping("/app/counts")
public class AppCountController {
	
    @Autowired
    private MeetingService meetingService;
    /**
     * APP用户端-统计活动信息未读数量
     * @return
     */
    @Login
    @GetMapping("getmeetcounts")
    public R getmeetcounts(@RequestAttribute("userId") Long userId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        int meetcounts = 0; 
        meetcounts = meetingService.getmeetcounts(userId);
        return R.ok().put("meetnotreadcounts", meetcounts);
    }
}
