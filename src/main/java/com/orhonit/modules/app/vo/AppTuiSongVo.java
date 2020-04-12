package com.orhonit.modules.app.vo;

import lombok.Data;

@Data
public class AppTuiSongVo {
	
	private Integer newpId;
	
	private Integer newId;
	
	private Long meetId;
	
	private Integer TypeCode; //0:欢迎新成员。1:记忆与思念。2:支部活动
	
}
