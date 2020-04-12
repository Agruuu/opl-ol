package com.orhonit.modules.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.orhonit.modules.app.vo.AppMeetingVo;
import com.orhonit.modules.app.vo.AppOneMeetVo;

@Mapper
public interface AppMeetingDao extends BaseMapper<AppMeetingVo>{

	List<AppMeetingVo> getMeetingList(@Param("beginLimit")int beginLimit, @Param("limit")int limit, @Param("userId")long userId);
	
	List<AppMeetingVo> getJoinMeetList(@Param("beginLimit")int beginLimit, @Param("limit")int limit, @Param("userId")long userId);

	void updateMeetStatus(@Param("meetStatus")int meetStatus,@Param("meetId")long meetId);

	void updMeetPeople(@Param("peopleId")Integer peopleId);

	void updSignin(@Param("peopleId")Integer peopleId);

	int countNotRead(@Param("userId")Long userId);

	AppOneMeetVo userGetOneMeet(@Param("peopleId")Integer peopleId);

	AppOneMeetVo deptMeetInfo(@Param("peopleId")Integer peopleId);

	void peopleJoin(@Param("peopleId")Integer peopleId,@Param("stationId")Integer stationId,@Param("peopleNeedMeet")Integer peopleNeedMeet,@Param("peopleLveMsg") String peopleLveMsg);



}
