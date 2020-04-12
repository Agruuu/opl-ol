package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 我的述求
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-25 16:47:20
 */
@TableName("tb_myrequest")
public class MyrequestEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 我的述求id
	 */
	@TableId
	private Integer myreqId;
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
	
	private Integer orgId;
	/**
	 * 回复人id
	 */
	private Long resUserId;
	
	private Integer myreqDeptororg;
	
	public Integer getMyreqDeptororg() {
		return myreqDeptororg;
	}
	public void setMyreqDeptororg(Integer myreqDeptororg) {
		this.myreqDeptororg = myreqDeptororg;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
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
	 * 设置：我的述求id
	 */
	public void setMyreqId(Integer myreqId) {
		this.myreqId = myreqId;
	}
	/**
	 * 获取：我的述求id
	 */
	public Integer getMyreqId() {
		return myreqId;
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
