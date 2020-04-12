package com.orhonit.modules.app.vo;

import java.io.Serializable;
import java.util.Date;

public class AppNewsComReplyVo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String replyContent;
	
	private int userId;
	
	private String userName;
	
	private String replyTo;
	
	private Date crtTime;
	
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
	public Date getCrtTime() {
		return crtTime;
	}
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	
	
}
