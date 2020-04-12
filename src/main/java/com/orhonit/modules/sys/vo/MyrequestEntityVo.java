package com.orhonit.modules.sys.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的述求
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-25 16:47:20
 */
public class MyrequestEntityVo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 述求内容
	 */
	private String myreqReq;
	/**
	 * 管理员答复
	 */
	private String myreqRes;
	/**
	 * 提出时间
	 */
	private Date myreqReqTime;
	/**
	 * 回复时间
	 */
	private Date myreqResTime;
	/**
	 * 是否回复：0否，1是
	 */
	private Integer myreqIsRes;
	/**
	 * 填报人id
	 */
	private Long reqUserId;
	/**
	 * 填报人支部id
	 */
	private Integer deptId;
	/**
	 * 回复人id
	 */
	private Long resUserId;
	
	private String reqName;
	
	private String resName;
	
	public String getReqName() {
		return reqName;
	}
	public void setReqName(String reqName) {
		this.reqName = reqName;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public Long getReqUserId() {
		return reqUserId;
	}
	public void setReqUserId(Long reqUserId) {
		this.reqUserId = reqUserId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Long getResUserId() {
		return resUserId;
	}
	public void setResUserId(Long resUserId) {
		this.resUserId = resUserId;
	}
	/**
	 * 设置：述求内容
	 */
	public void setMyreqReq(String myreqReq) {
		this.myreqReq = myreqReq;
	}
	/**
	 * 获取：述求内容
	 */
	public String getMyreqReq() {
		return myreqReq;
	}
	/**
	 * 设置：管理员答复
	 */
	public void setMyreqRes(String myreqRes) {
		this.myreqRes = myreqRes;
	}
	/**
	 * 获取：管理员答复
	 */
	public String getMyreqRes() {
		return myreqRes;
	}
	/**
	 * 设置：提出时间
	 */
	public void setMyreqReqTime(Date myreqReqTime) {
		this.myreqReqTime = myreqReqTime;
	}
	/**
	 * 获取：提出时间
	 */
	public Date getMyreqReqTime() {
		return myreqReqTime;
	}
	/**
	 * 设置：回复时间
	 */
	public void setMyreqResTime(Date myreqResTime) {
		this.myreqResTime = myreqResTime;
	}
	/**
	 * 获取：回复时间
	 */
	public Date getMyreqResTime() {
		return myreqResTime;
	}
	/**
	 * 设置：是否回复：0否，1是
	 */
	public void setMyreqIsRes(Integer myreqIsRes) {
		this.myreqIsRes = myreqIsRes;
	}
	/**
	 * 获取：是否回复：0否，1是
	 */
	public Integer getMyreqIsRes() {
		return myreqIsRes;
	}
}
