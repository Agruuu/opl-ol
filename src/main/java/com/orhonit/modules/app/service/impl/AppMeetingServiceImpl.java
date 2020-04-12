package com.orhonit.modules.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.modules.app.dao.AppMeetingDao;
import com.orhonit.modules.app.service.AppMeetingService;
import com.orhonit.modules.app.vo.AppMeetingVo;
import com.orhonit.modules.app.vo.AppOneMeetVo;

@Service("AppMeetingService")
public class AppMeetingServiceImpl extends ServiceImpl<AppMeetingDao, AppMeetingVo> implements AppMeetingService{
	
	@Autowired
	private AppMeetingDao appMeetingDao;
	@Override
	public PageUtils meetingList(Map<String, Object> params, long userId) {
		int currPage = 1;
		int limit = 20;
		 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
		Page<AppMeetingVo> page = new Page<AppMeetingVo>();
		int beginLimit = (currPage-1)*limit;
		List<AppMeetingVo> peopleMeetList = appMeetingDao.getMeetingList(beginLimit,limit,userId);
		List<AppMeetingVo> outPeopleMeetList = new ArrayList<>();
		Date nowTime = new Date();
		int meetStatus = 0;
		for(AppMeetingVo peopleMeet:peopleMeetList) {
			if(peopleMeet.getMeetingStatus()==2){	
			}else if(peopleMeet.getMeetingStatus()==0) {
				if(peopleMeet.getMeetBeginTime().before(nowTime)&&peopleMeet.getMeetEndTime().after(nowTime)) {
					meetStatus=1;
					peopleMeet.setMeetingStatus(1);
					appMeetingDao.updateMeetStatus(meetStatus,peopleMeet.getMeetId());
				}else if(peopleMeet.getMeetEndTime().before(nowTime)){
					meetStatus=2;
					peopleMeet.setMeetingStatus(2);
					appMeetingDao.updateMeetStatus(meetStatus,peopleMeet.getMeetId());			
				}
			}else if(peopleMeet.getMeetingStatus()==1){
				if(peopleMeet.getMeetEndTime().before(nowTime)){
					meetStatus=2;
					peopleMeet.setMeetingStatus(2);
					appMeetingDao.updateMeetStatus(meetStatus,peopleMeet.getMeetId());		
				}
			}
			outPeopleMeetList.add(peopleMeet);
		}
		page.setRecords(peopleMeetList);
		
        return new PageUtils(page);
	}
	
	@Override
	public PageUtils getJoinMeetList(Map<String, Object> params, long userId) {
		int currPage = 1;
		int limit = 20;
		 if(params.get("page") != null){
             currPage = Integer.parseInt((String)params.get("page"));
         }
         if(params.get("limit") != null){
             limit = Integer.parseInt((String)params.get("limit"));
         }
		Page<AppMeetingVo> page = new Page<AppMeetingVo>();
		int beginLimit = (currPage-1)*limit;
		List<AppMeetingVo> JoinMeetList = appMeetingDao.getJoinMeetList(beginLimit,limit,userId);
		Date nowTime = new Date();
		int meetStatus = 0;
		for(AppMeetingVo peopleMeet:JoinMeetList) {
			if(peopleMeet.getMeetingStatus()==2){	
			}else if(peopleMeet.getMeetingStatus()==0) {
				if(peopleMeet.getMeetBeginTime().before(nowTime)&&peopleMeet.getMeetEndTime().after(nowTime)) {
					meetStatus=1;
					peopleMeet.setMeetingStatus(1);
					appMeetingDao.updateMeetStatus(meetStatus,peopleMeet.getMeetId());
				}else if(peopleMeet.getMeetEndTime().before(nowTime)){
					meetStatus=2;
					peopleMeet.setMeetingStatus(2);
					appMeetingDao.updateMeetStatus(meetStatus,peopleMeet.getMeetId());			
				}
			}else if(peopleMeet.getMeetingStatus()==1){
				if(peopleMeet.getMeetEndTime().before(nowTime)){
					meetStatus=2;
					peopleMeet.setMeetingStatus(2);
					appMeetingDao.updateMeetStatus(meetStatus,peopleMeet.getMeetId());		
				}
			}
		}
		page.setRecords(JoinMeetList);
		
        return new PageUtils(page);
	}
	
	//用户获取活动信息详情
	@Override
	public AppOneMeetVo userGetOneMeet(Integer peopleId) {
		// TODO Auto-generated method stub
		appMeetingDao.updMeetPeople(peopleId);
		AppOneMeetVo appOneMeetVo = appMeetingDao.userGetOneMeet(peopleId);
		if(appOneMeetVo.getPeopleJoin()==0&&appOneMeetVo.getMeetEndTime().before(new Date())){
			appOneMeetVo.setPeopleJoinMessage("未参加");
		}else if(appOneMeetVo.getPeopleJoin()==0) {
			appOneMeetVo.setPeopleJoinMessage("报名参加");
		}else if(appOneMeetVo.getPeopleJoin()==1) {
			appOneMeetVo.setPeopleJoinMessage("已参加");
		}
		return appOneMeetVo;
	}
	
	//修改预览状态
	@Override
	public void updMeetPeople(Integer peopleId) {
		appMeetingDao.updMeetPeople(peopleId);
		
	}
	//修改签到状态
	@Override
	public void updSignin(Integer peopleId) {
		// TODO Auto-generated method stub
		
		appMeetingDao.updSignin(peopleId);
	}
	@Override
	public int countNotRead(Long userId) {
		// TODO Auto-generated method stub
		return appMeetingDao.countNotRead(userId);
	}

	@Override
	public void peopleJoin(Integer peopleId,Integer stationId,Integer peopleNeedMeet, String peopleLveMsg) {
		// TODO Auto-generated method stub
		appMeetingDao.peopleJoin(peopleId,stationId,peopleNeedMeet,peopleLveMsg);
	}

}
