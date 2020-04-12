package com.orhonit.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.sys.entity.MeetingEntity;
import com.orhonit.modules.sys.vo.MeetPeopleVo;

import java.util.List;
import java.util.Map;

/**
 * 支部活动表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-14 14:56:22
 */
public interface MeetingService extends IService<MeetingEntity> {

    PageUtils queryPage(Map<String, Object> params,long getUserId);

	void setMeetUsers(long ts,String userArea,Integer userOrg);
	
	void saveMeetByArea(long ts,String userArea,Integer userOrg);
	
	void saveMeetAll(long ts,String userArea,Integer userOrg);
	
	void insertMeet(MeetingEntity meeting);

	List<MeetPeopleVo> getIsSigninAndStation(Long meetId);

	int getmeetcounts(Long userId);
}

