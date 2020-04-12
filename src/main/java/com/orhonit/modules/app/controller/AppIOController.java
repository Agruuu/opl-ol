package com.orhonit.modules.app.controller;

import java.io.File;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.DeleteFileUtil;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;

@RestController
@RequestMapping("/app")
public class AppIOController {
	
	@Login
	@PutMapping("deleteFile")
	public R deleteFile(@RequestParam String url){
		File file = new File(url);
		
		return DeleteFileUtil.deleteFile(file);		
	} 
}
