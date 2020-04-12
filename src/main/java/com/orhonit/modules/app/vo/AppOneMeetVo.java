package com.orhonit.modules.app.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class AppOneMeetVo implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer peopleId;
	
	private Long meetId;
	
	private Integer peopleNeedMeet;
	
	private Integer peopleIsRead;
	
	private Integer peopleIsSignin;
	
	private Integer stationId;
	
	private Integer peopleJoin;
	
	private String peopleJoinMessage;

	/**
	 * 会议名称
	 */
	private String meetTitle;

	private String meetContent;
	/**
	 * 会议状态0:未开始，1：进行中，2：已结束，
	 */
	private Integer meetingStatus;	
	
	private Integer routeId;
	
	private Date meetBeginTime;
	
	private Date meetEndTime;
	
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date crtTime;
	/**
	 * 路线名称
	 */
	private String routeName;
	
	private String stationName;
	/**
	 * 上车时间
	 */
	private Date stationArrivalTime;
	
	
	public Integer getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(Integer peopleId) {
		this.peopleId = peopleId;
	}
	public Date getStationArrivalTime() {
		return stationArrivalTime;
	}
	public void setStationArrivalTime(Date stationArrivalTime) {
		this.stationArrivalTime = stationArrivalTime;
	}
	public String getPeopleJoinMessage() {
		return peopleJoinMessage;
	}
	public void setPeopleJoinMessage(String peopleJoinMessage) {
		this.peopleJoinMessage = peopleJoinMessage;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public Integer getPeopleJoin() {
		return peopleJoin;
	}
	public void setPeopleJoin(Integer peopleJoin) {
		this.peopleJoin = peopleJoin;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public Integer getPeopleNeedMeet() {
		return peopleNeedMeet;
	}
	public void setPeopleNeedMeet(Integer peopleNeedMeet) {
		this.peopleNeedMeet = peopleNeedMeet;
	}
	public Integer getPeopleIsSignin() {
		return peopleIsSignin;
	}
	public void setPeopleIsSignin(Integer peopleIsSignin) {
		this.peopleIsSignin = peopleIsSignin;
	}
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public String getMeetContent() {
		return meetContent;
	}
	public void setMeetContent(String meetContent) {
		this.meetContent = meetContent;
	}
	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Long getMeetId() {
		return meetId;
	}
	public void setMeetId(Long meetId) {
		this.meetId = meetId;
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
