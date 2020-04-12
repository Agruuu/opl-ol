package com.orhonit.modules.sys.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;


/**
 * 会议提醒表
 * 
 * @author cyf
 * @email cyf0477@126.com
 * @version 2018-04-11 09:42:23
 */
@Table(name = "cpc_message_reminding")
public class CpcMessageReminding implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //id
    @Id
    private String id;
	
	    //提醒支部
    @Column(name = "remind_dept_id")
    private String remindDeptId;
    
	    //被提醒支部
    @Column(name = "reminded_dept_id")
    private String remindedDeptId;
	
	    //提醒时间
    @Column(name = "remind_time")
    private Timestamp remindTime;
	
	    //提醒标题 
    @Column(name = "remind_title")
    private String remindTitle;
	
	    //提醒内容
    @Column(name = "remind_content")
    private String remindContent;
	
	    //会议时间
    @Column(name = "meeting_time")
    private Timestamp meetingTime;
	
	    //状态
    @Column(name = "status")
    private String status;
	
	    //预留字段2
    @Column(name = "reserve2")
    private String reserve2;
	
	    //预留字段3
    @Column(name = "reserve3")
    private String reserve3;
	
    	//提醒支部名称
    private String remindDeptName;
    
    	//String时间
    @Transient
    private String time ;
    
    
    
    
    
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRemindDeptName() {
		return remindDeptName;
	}
	public void setRemindDeptName(String remindDeptName) {
		this.remindDeptName = remindDeptName;
	}
	/**
	 * 设置：id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：提醒支部
	 */
	public void setRemindDeptId(String remindDeptId) {
		this.remindDeptId = remindDeptId;
	}
	/**
	 * 获取：提醒支部
	 */
	public String getRemindDeptId() {
		return remindDeptId;
	}
	/**
	 * 设置：被提醒支部
	 */
	public void setRemindedDeptId(String remindedDeptId) {
		this.remindedDeptId = remindedDeptId;
	}
	/**
	 * 获取：被提醒支部
	 */
	public String getRemindedDeptId() {
		return remindedDeptId;
	}
	/**
	 * 设置：提醒时间
	 */
	public void setRemindTime(Timestamp remindTime) {
		this.remindTime = remindTime;
	}
	/**
	 * 获取：提醒时间
	 */
	public Timestamp getRemindTime() {
		return remindTime;
	}
	/**
	 * 设置：提醒标题 
	 */
	public void setRemindTitle(String remindTitle) {
		this.remindTitle = remindTitle;
	}
	/**
	 * 获取：提醒标题 
	 */
	public String getRemindTitle() {
		return remindTitle;
	}
	/**
	 * 设置：提醒内容
	 */
	public void setRemindContent(String remindContent) {
		this.remindContent = remindContent;
	}
	/**
	 * 获取：提醒内容
	 */
	public String getRemindContent() {
		return remindContent;
	}
	/**
	 * 设置：会议时间
	 */
	public void setMeetingTime(Timestamp meetingTime) {
		this.meetingTime = meetingTime;
	}
	/**
	 * 获取：会议时间
	 */
	public Timestamp getMeetingTime() {
		return meetingTime;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：预留字段2
	 */
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	/**
	 * 获取：预留字段2
	 */
	public String getReserve2() {
		return reserve2;
	}
	/**
	 * 设置：预留字段3
	 */
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	/**
	 * 获取：预留字段3
	 */
	public String getReserve3() {
		return reserve3;
	}
}
