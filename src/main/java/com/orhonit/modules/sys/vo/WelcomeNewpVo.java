package com.orhonit.modules.sys.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class WelcomeNewpVo {
	
	private Integer newpId;
	private Long newpUserId;
	private  Date crtTime;
	private String userTrueName;
	private Integer userSex;
	@JsonFormat(pattern="yyyy年MM月dd日")
	private  Date userBirthday;
	private String userHeadPicture;
	private String userWork;
	private String email;
	private String dictName;
}
