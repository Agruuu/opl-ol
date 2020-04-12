package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 支部活动表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-14 14:56:22
 */
@TableName("tb_meeting")
public class MeetingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long meetId;
	/**
	 * 会议名称
	 */
	private String meetTitle;
	/**
	 * 会议内容
	 */
	private String meetContent;

	/**
	 * 会议状态0:未开始，1：进行中，2：已结束，3：已取消
	 */
	private Integer meetingStatus;
	/**
	 * 创建人id
	 */
	private Long userId;
	/**
	 * 创建时间
	 */
	private Date crtTime;
	/**
	 * 更新时间
	 */
	private Date updTime;
	/**
	 * 会议部门
	 */
	private String userArea;
	/**
	 * 会议单位
	 */
	private Integer orgId;
	/**
	 * 路线id
	 */
	private Integer routeId;
	/**
	 * 会议开始时间
	 */
	private Date meetBeginTime;	
	/**
	 * 会议结束时间
	 */
	private Date meetEndTime;
	
	public String getUserArea() {
		return userArea;
	}
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}
	public Date getMeetBeginTime() {
		return meetBeginTime;
	}
	public void setMeetBeginTime(Date meetBeginTime) {
		this.meetBeginTime = meetBeginTime;
	}
	public Date getMeetEndTime() {
		return meetEndTime;
	}
	public void setMeetEndTime(Date meetEndTime) {
		this.meetEndTime = meetEndTime;
	}
	/**
	 * 设置：
	 */
	public void setMeetId(Long meetId) {
		this.meetId = meetId;
	}
	/**
	 * 获取：
	 */
	public Long getMeetId() {
		return meetId;
	}
	/**
	 * 设置：会议名称
	 */
	public void setMeetTitle(String meetTitle) {
		this.meetTitle = meetTitle;
	}
	/**
	 * 获取：会议名称
	 */
	public String getMeetTitle() {
		return meetTitle;
	}
	/**
	 * 设置：会议内容
	 */
	public void setMeetContent(String meetContent) {
		this.meetContent = meetContent;
	}
	/**
	 * 获取：会议内容
	 */
	public String getMeetContent() {
		return meetContent;
	}
	/**
	 * 设置：会议状态0:未开始，1：进行中，2：已结束，3：已取消
	 */
	public void setMeetingStatus(Integer meetingStatus) {
		this.meetingStatus = meetingStatus;
	}
	/**
	 * 获取：会议状态0:未开始，1：进行中，2：已结束，3：已取消
	 */
	public Integer getMeetingStatus() {
		return meetingStatus;
	}
	/**
	 * 设置：创建人id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：创建人id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCrtTime() {
		return crtTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdTime() {
		return updTime;
	}
	/**
	 * 设置：会议单位
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：会议单位
	 */
	public Integer getOrgId() {
		return orgId;
	}
	/**
	 * 设置：路线id
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	/**
	 * 获取：路线id
	 */
	public Integer getRouteId() {
		return routeId;
	}
}
