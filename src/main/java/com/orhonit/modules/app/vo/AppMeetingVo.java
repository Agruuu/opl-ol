package com.orhonit.modules.app.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class AppMeetingVo implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long meetId;
	
	private Integer peopleId;
	
	private Integer peopleIsRead;
	
	private Integer peopleIsSignin;

	/**
	 * 会议名称
	 */
	private String meetTitle;

	/**
	 * 会议状态0:未开始，1：进行中，2：已结束，
	 */
	private Integer meetingStatus;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date crtTime;
	
	private Date meetBeginTime;
	
	private Date meetEndTime;
	
	public Integer getPeopleIsSignin() {
		return peopleIsSignin;
	}
	public void setPeopleIsSignin(Integer peopleIsSignin) {
		this.peopleIsSignin = peopleIsSignin;
	}
	public Long getMeetId() {
		return meetId;
	}
	public void setMeetId(Long meetId) {
		this.meetId = meetId;
	}
	public Integer getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Integer peopleId) {
		this.peopleId = peopleId;
	}
	public Integer getPeopleIsRead() {
		return peopleIsRead;
	}
	public void setPeopleIsRead(Integer peopleIsRead) {
		this.peopleIsRead = peopleIsRead;
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
}
