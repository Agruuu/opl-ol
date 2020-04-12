package com.orhonit.modules.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/tuishong")
public class JiGuangTuiSongController {
	
	@RequestMapping("test")
	public void tuiSongTest() {
//		List<String> a =  new ArrayList<>();
//		a.add("170976fa8ac5c80f25c");
//		JiguangPushUtil.jiguangPush(a,"试一下~~",0,appTuiSongVo);
	}
	
}
