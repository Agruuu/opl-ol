package com.orhonit.modules.sys.dao;

import com.orhonit.modules.sys.entity.MeetingEntity;
import com.orhonit.modules.sys.vo.MeetPeopleVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 支部活动表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-14 14:56:22
 */
@Mapper
public interface MeetingDao extends BaseMapper<MeetingEntity> {

	void setMeetUsers(@Param("ts")long ts,@Param("userArea")String userArea, @Param("userOrg")Integer userOrg);
	
	void saveMeetByArea(@Param("ts")long ts,@Param("userArea")String userArea, @Param("userOrg")Integer userOrg);
	
	void saveMeetAll(@Param("ts")long ts,@Param("userArea")String userArea, @Param("userOrg")Integer userOrg);
	
	void insertMeet(MeetingEntity meeting);

	List<MeetPeopleVo> getIsSigninAndStation(@Param("meetId")Long meetId);

	void updateMeetStatus(@Param("meetStatus")int meetStatus,@Param("meetId")long meetId);

	int getmeetcounts(@Param("userId")Long userId);
	
}
