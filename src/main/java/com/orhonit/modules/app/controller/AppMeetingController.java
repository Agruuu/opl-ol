package com.orhonit.modules.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.JiguangPushUtil;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.annotation.Login;
import com.orhonit.modules.app.annotation.LoginUser;
import com.orhonit.modules.app.entity.AppUserEntity;
import com.orhonit.modules.app.service.AppMeetingService;
import com.orhonit.modules.app.vo.AppOneMeetVo;
import com.orhonit.modules.app.vo.AppTuiSongVo;
import com.orhonit.modules.sys.dao.UserPhoneNumCardDao;
import com.orhonit.modules.sys.entity.MeetingEntity;
import com.orhonit.modules.sys.service.MeetingService;
import com.orhonit.modules.sys.vo.MeetPeopleVo;

@RestController
@RequestMapping("/app/meeting")
public class AppMeetingController{
	
	@Autowired
	private AppMeetingService appMeetingService;
	
    @Autowired
    private MeetingService meetingService;
    
    @Autowired
    private UserPhoneNumCardDao userPhoneNumCardDao;
    
    /**
     * 保存
     */
    @Login
    @RequestMapping("/save")
    //@RequiresPermissions("sys:meeting:save")
    public R save(@RequestBody MeetingEntity meeting,@LoginUser AppUserEntity user){
    	Date date = new Date();
    	long ts = date.getTime();
    	AppUserEntity userEntity = user;
    	//支部Id是否为空
    	if(userEntity.getUserOrg()!=null&&userEntity.getUserId()!=null) {
    		meeting.setUserId(userEntity.getUserId());
    		meeting.setOrgId(userEntity.getUserOrg());
    		meeting.setUserArea(userEntity.getUserArea());
    		meeting.setMeetId(ts);
    		//meeting.setOrgId(userEntity.getUserDept());
    		//添加会议
			meetingService.insertMeet(meeting);
			//添加参会人员，报错则回滚
			try {
	    		meetingService.setMeetUsers(ts,userEntity.getUserArea(),userEntity.getUserOrg());
			} catch (Exception e) {
				// TODO: handle exception
				//添加出错删除会议记录
				meetingService.deleteById(ts);
				return R.error();
			}
			//发送推送信息
			AppTuiSongVo appTuiSongVo = new AppTuiSongVo();
			appTuiSongVo.setTypeCode(2);
			appTuiSongVo.setMeetId(ts);
			String newTitle=meeting.getMeetTitle()+"将于【"+meeting.getMeetBeginTime()+"至"+meeting.getMeetEndTime()+"】举行。点击查看详情：";
			JiguangPushUtil.jiguangPush(userPhoneNumCardDao.selectByDeptId(userEntity.getUserDept()),newTitle,appTuiSongVo);
	        return R.ok();
    	}
    	return R.parameterIsNul();
    }
    
    
    /**
     * 信息
     */
    @Login
    @RequestMapping("/info/{meetId}")
    //@RequiresPermissions("sys:meeting:info")
    public R info(@PathVariable("meetId") Integer meetId){
			MeetingEntity meeting = meetingService.selectById(meetId);

        return R.ok().put("meeting", meeting);
    }
    
    /**
     * 修改
     */
    @Login
    @RequestMapping("/update")
    //@RequiresPermissions("sys:meeting:update")
    public R update(@RequestBody MeetingEntity meeting){
			meetingService.updateById(meeting);

        return R.ok();
    }

    /**
     * 删除
     */
    @Login
    @RequestMapping("/delete")
   //@RequiresPermissions("sys:meeting:delete")
    public R delete(@RequestBody Integer[] meetIds){
			meetingService.deleteBatchIds(Arrays.asList(meetIds));

        return R.ok();
    }
    
   /**
    * 查询人员接送站点和签到情况
    */
    @Login
    @RequestMapping("/getIsSigninAndStation")
  //@RequiresPermissions("sys:meeting:delete")
   public R getIsSigninAndStation(@RequestParam Long meetId){
	   List<MeetPeopleVo> meetPeopleVo = meetingService.getIsSigninAndStation(meetId);

       return R.ok().put("meetPeopleVo", meetPeopleVo);
   }
	
    /**
     * 支部活动列表
     */
	@Login
    @RequestMapping("meetinglist")
    //@RequiresPermissions("sys:meeting:list")
    public R meetinglist(@RequestParam Map<String, Object> params,@RequestAttribute("userId") Long userId){
    	if(userId!=null){
	        PageUtils page = appMeetingService.meetingList(params,userId);
	
	        return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }
	
    /**
     * 我参加的活动以及出勤情况
     */
	@Login
    @RequestMapping("getJoinMeet")
    //@RequiresPermissions("sys:meeting:list")
    public R getJoinMeetList(@RequestParam Map<String, Object> params,@RequestAttribute("userId") Long userId){
    	if(userId!=null){
	        PageUtils page = appMeetingService.getJoinMeetList(params,userId);
	
	        return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }
		
	/**
	 * 用户获取活动信息详情
	 * @param params
	 * @param userId
	 * @return
	 */
	@Login
    @GetMapping("userGetOneMeet")
    //@RequiresPermissions("sys:meeting:list")
    public R userGetOneMeet(@RequestParam Integer peopleId){
    	
	    AppOneMeetVo appOneMeetVo = appMeetingService.userGetOneMeet(peopleId);
	
    	return R.ok().put("appOneMeetVo", appOneMeetVo);
    }
	
	/**
	 * 修改阅读状态为已读
	 * @param peopleId
	 * @return
	 */
	@Login
    @PutMapping("updRead")
    //@RequiresPermissions("sys:meeting:list")
    public R updMeetPeople(@RequestParam Integer peopleId){
	      appMeetingService.updMeetPeople(peopleId);
    	return R.ok();
    }
	
	/**
	 * 修改签到状态为未签到
	 * @param peopleId
	 * @return
	 */
	@Login
    @PutMapping("updSignin")
    //@RequiresPermissions("sys:meeting:list")
    public R updSignin(@RequestParam Integer peopleId){
	      appMeetingService.updSignin(peopleId);
    	return R.ok();
    }
	
	/**
	 * 统计用户未读活动信息数量
	 * @param peopleId
	 * @return
	 */
	@Login
    @GetMapping("countNotRead")
    //@RequiresPermissions("sys:meeting:list")
    public R countNotRead(@RequestAttribute("userId") Long userId){
		if(userId!=null){
	       int notReadNum= appMeetingService.countNotRead(userId);
	        return R.ok().put("countNotRead", notReadNum);
    	}
    	return R.parameterIsNul();
    }
	
	/**
	 * 报名接口
	 * @param peopleId
	 * @return
	 */
	@Login
    @PutMapping("toJoin")
    //@RequiresPermissions("sys:meeting:list")
    public R peopleJoin(@RequestParam Integer peopleId,
    					@RequestParam Integer stationId,
    					@RequestParam Integer peopleNeedMeet,
    					@RequestParam String peopleLveMsg){
		 appMeetingService.peopleJoin(peopleId,stationId,peopleNeedMeet,peopleLveMsg);
		 return R.ok();
    }
	
}
