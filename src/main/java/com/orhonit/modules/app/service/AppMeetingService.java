package com.orhonit.modules.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.app.vo.AppMeetingVo;
import com.orhonit.modules.app.vo.AppOneMeetVo;

public interface AppMeetingService extends IService<AppMeetingVo>{

	PageUtils meetingList(Map<String, Object> params, long userId);
	
	PageUtils getJoinMeetList(Map<String, Object> params, long userId);

	void updMeetPeople(Integer peopleId);

	void updSignin(Integer peopleId);

	int countNotRead(Long userId);

	AppOneMeetVo userGetOneMeet(Integer peopleId);

	void peopleJoin(Integer peopleId,Integer stationId,Integer peopleNeedMeet, String peopleLveMsg);
		
}
