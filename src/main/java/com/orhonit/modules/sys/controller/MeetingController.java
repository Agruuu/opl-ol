package com.orhonit.modules.sys.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orhonit.common.utils.JiguangPushUtil;
import com.orhonit.common.utils.PageUtils;
import com.orhonit.common.utils.R;
import com.orhonit.modules.app.service.AppMeetingService;
import com.orhonit.modules.app.vo.AppTuiSongVo;
import com.orhonit.modules.sys.dao.UserPhoneNumCardDao;
import com.orhonit.modules.sys.entity.MeetingEntity;
import com.orhonit.modules.sys.entity.SysUserEntity;
import com.orhonit.modules.sys.service.MeetingService;
import com.orhonit.modules.sys.vo.MeetPeopleVo;



/**
 * 支部活动表
 *
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-14 14:56:22
 */
@RestController
@RequestMapping("sys/meeting")
public class MeetingController extends AbstractController{
    @Autowired
    private MeetingService meetingService;
    
    @Autowired
    private AppMeetingService appMeetingService;

    @Autowired
    private UserPhoneNumCardDao userPhoneNumCardDao; 
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("sys:meeting:list")
    public R list(@RequestParam Map<String, Object> params){
    	if(getUserId()!=null){
	        PageUtils page = meetingService.queryPage(params,getUserId());
	
	        return R.ok().put("page", page);
    	}
    	return R.parameterIsNul();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{meetId}")
    //@RequiresPermissions("sys:meeting:info")
    public R info(@PathVariable("meetId") Integer meetId){
			MeetingEntity meeting = meetingService.selectById(meetId);

        return R.ok().put("meeting", meeting);
    }

    /**
     * pc管理端-支部活动-按单位(orgId)添加活动
     */
    @RequestMapping("/save")
    //@RequiresPermissions("sys:meeting:save")
    public R save(@RequestBody MeetingEntity meeting){
    	Date date = new Date();
    	long ts = date.getTime();
    	SysUserEntity userEntity = getUser();
    	//支部Id是否为空
    	if(userEntity.getUserOrg()==null) {
    		return R.error(-1,"未找到管理员所在单位信息，请为管理员添加单位信息或重新登录~");
    	}else if(userEntity.getUserArea()==null){
    		return R.error(-1,"未找到管理员所在旗区信息，请为管理员添加旗区信息或重新登录~");
    	}else if(userEntity.getUserId()==null) {
    		return R.error(-1,"管理员ID获取失败，请重新登陆~");
    	}
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
    
    /**
     * pc管理端-支部活动-按旗区(userArea)添加活动
     */
    @RequestMapping("/saveMeetByArea")
    //@RequiresPermissions("sys:meeting:save")
    public R saveMeetByArea(@RequestBody MeetingEntity meeting){
    	Date date = new Date();
    	long ts = date.getTime();
    	SysUserEntity userEntity = getUser();
    	//支部Id是否为空
    	if(userEntity.getUserOrg()==null) {
    		return R.error(-1,"未找到管理员所在单位信息，请为管理员添加单位信息或重新登录~");
    	}else if(userEntity.getUserArea()==null){
    		return R.error(-1,"未找到管理员所在旗区信息，请为管理员添加旗区信息或重新登录~");
    	}else if(userEntity.getUserId()==null) {
    		return R.error(-1,"管理员ID获取失败，请重新登陆~");
    	}
    		meeting.setUserId(userEntity.getUserId());
    		meeting.setOrgId(userEntity.getUserOrg());
    		meeting.setUserArea(userEntity.getUserArea());
    		meeting.setMeetId(ts);
    		//meeting.setOrgId(userEntity.getUserDept());
    		//添加会议
			meetingService.insertMeet(meeting);
			//添加参会人员，报错则回滚
			try {
	    		meetingService.saveMeetByArea(ts,userEntity.getUserArea(),userEntity.getUserOrg());
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
    
    /**
     * pc管理端-支部活动-添加活动(全区)
     */
    @RequestMapping("/saveMeetAll")
    //@RequiresPermissions("sys:meeting:save")
    public R saveMeetAll(@RequestBody MeetingEntity meeting){
    	Date date = new Date();
    	long ts = date.getTime();
    	SysUserEntity userEntity = getUser();
    	//支部Id是否为空
    	if(userEntity.getUserOrg()==null) {
    		return R.error(-1,"未找到管理员所在单位信息，请为管理员添加单位信息或重新登录~");
    	}else if(userEntity.getUserArea()==null){
    		return R.error(-1,"未找到管理员所在旗区信息，请为管理员添加旗区信息或重新登录~");
    	}else if(userEntity.getUserId()==null) {
    		return R.error(-1,"管理员ID获取失败，请重新登陆~");
    	}
    		meeting.setUserId(userEntity.getUserId());
    		meeting.setOrgId(userEntity.getUserOrg());
    		meeting.setUserArea(userEntity.getUserArea());
    		meeting.setMeetId(ts);
    		//meeting.setOrgId(userEntity.getUserDept());
    		//添加会议
			meetingService.insertMeet(meeting);
			//添加参会人员，报错则回滚
			try {
	    		meetingService.saveMeetAll(ts,userEntity.getUserArea(),userEntity.getUserOrg());
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
   
    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("sys:meeting:update")
    public R update(@RequestBody MeetingEntity meeting){
			meetingService.updateById(meeting);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   //@RequiresPermissions("sys:meeting:delete")
    public R delete(@RequestBody Integer[] meetIds){
			meetingService.deleteBatchIds(Arrays.asList(meetIds));

        return R.ok();
    }
    
   /**
    * 查询人员接送站点和签到情况
    */
   @RequestMapping("/getIsSigninAndStation")
  //@RequiresPermissions("sys:meeting:delete")
   public R getIsSigninAndStation(@RequestParam Long meetId){
	   List<MeetPeopleVo> meetPeopleVo = meetingService.getIsSigninAndStation(meetId);

       return R.ok().put("meetPeopleVo", meetPeopleVo);
   }
   
	/**
	 * 修改签到状态为未签到
	 * @param peopleId
	 * @return
	 */
   @PutMapping("/updSignin")
   //@RequiresPermissions("sys:meeting:list")
   public R updSignin(@RequestParam Integer peopleId){
	      appMeetingService.updSignin(peopleId);
   	return R.ok();
   }

}
