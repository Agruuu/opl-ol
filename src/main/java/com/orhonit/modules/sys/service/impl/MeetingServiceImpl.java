package com.orhonit.modules.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.Query;
import com.orhonit.modules.sys.dao.MeetingDao;
import com.orhonit.modules.sys.entity.MeetingEntity;
import com.orhonit.modules.sys.service.MeetingService;
import com.orhonit.modules.sys.vo.MeetPeopleVo;


@Service("meetingService")
public class MeetingServiceImpl extends ServiceImpl<MeetingDao, MeetingEntity> implements MeetingService {
	@Autowired
	private MeetingDao meetingDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params,long userId) {
    	if(params.get("meetTitle")!=null) {
            Page<MeetingEntity> page = this.selectPage(
                    new Query<MeetingEntity>(params).getPage(),
                    new EntityWrapper<MeetingEntity>().like("meet_title",params.get("meetTitle").toString()).where("user_id={0}",userId).orderBy("meet_id DESC")
            );
            page.setTotal(this.selectCount(new EntityWrapper<MeetingEntity>().like("meet_title",params.get("meetTitle").toString()).where("user_id={0}", userId)));
            return new PageUtils(page);
    	}
    	 Page<MeetingEntity> page = this.selectPage(
                 new Query<MeetingEntity>(params).getPage(),
                 new EntityWrapper<MeetingEntity>().where("user_id={0}",userId).orderBy("meet_id DESC")
         );	  	 
    	 if(page.getRecords()!=null) {
    		 List<MeetingEntity> outPeopleMeetList = new ArrayList<>();
    		 Date nowTime = new Date();
    		 int meetStatus = 0;
    		 for(MeetingEntity peopleMeet:page.getRecords()) {
    	 			if(peopleMeet.getMeetingStatus()==2){	
    	 			}else if(peopleMeet.getMeetingStatus()==0) {
    	 				if(peopleMeet.getMeetBeginTime().before(nowTime)&&peopleMeet.getMeetEndTime().after(nowTime)) {
    	 					meetStatus=1;
    	 					peopleMeet.setMeetingStatus(1);
    	 					meetingDao.updateMeetStatus(meetStatus,peopleMeet.getMeetId());
    	 				}else if(peopleMeet.getMeetEndTime().before(nowTime)){
    	 					meetStatus=2;
    	 					peopleMeet.setMeetingStatus(2);
    	 					meetingDao.updateMeetStatus(meetStatus,peopleMeet.getMeetId());			
    	 				}
    	 			}else if(peopleMeet.getMeetingStatus()==1){
    	 				if(peopleMeet.getMeetEndTime().before(nowTime)){
    	 					meetStatus=2;
    	 					peopleMeet.setMeetingStatus(2);
    	 					meetingDao.updateMeetStatus(meetStatus,peopleMeet.getMeetId());		
    	 				}
    	 			}
    	 			outPeopleMeetList.add(peopleMeet);
    	 		}
    		 page.setRecords(outPeopleMeetList);
    	 }
    	
         page.setTotal(this.selectCount(new EntityWrapper<MeetingEntity>().where("user_id={0}", userId)));
         return new PageUtils(page);

    }

	@Override
	public void setMeetUsers(long ts,String userArea,Integer userOrg) {
		// TODO Auto-generated method stub
		meetingDao.setMeetUsers(ts,userArea,userOrg);
	}
	
	@Override
	public void saveMeetByArea(long ts,String userArea,Integer userOrg) {
		// TODO Auto-generated method stub
		meetingDao.saveMeetByArea(ts,userArea,userOrg);
	}

	@Override
	public void saveMeetAll(long ts,String userArea,Integer userOrg) {
		// TODO Auto-generated method stub
		meetingDao.saveMeetAll(ts,userArea,userOrg);
	}
	
	@Override
	public void insertMeet(MeetingEntity meeting) {
		// TODO Auto-generated method stub
		meetingDao.insertMeet(meeting);
	}

	@Override
	public List<MeetPeopleVo> getIsSigninAndStation(Long meetId) {
		// TODO Auto-generated method stub
		return meetingDao.getIsSigninAndStation(meetId);
	}

	@Override
	public int getmeetcounts(Long userId) {
		// TODO Auto-generated method stub
		return meetingDao.getmeetcounts(userId);
	}

}
