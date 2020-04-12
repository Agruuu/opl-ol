package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户备忘录表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-03-04 14:35:59
 */
@TableName("tb_user_memorandum")
public class UserMemorandumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer memorandumId;
	/**
	 * 
	 */
	private String memorandumContent;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 
	 */
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date ctrTime;

	/**
	 * 设置：
	 */
	public void setMemorandumId(Integer memorandumId) {
		this.memorandumId = memorandumId;
	}
	/**
	 * 获取：
	 */
	public Integer getMemorandumId() {
		return memorandumId;
	}
	/**
	 * 设置：
	 */
	public void setMemorandumContent(String memorandumContent) {
		this.memorandumContent = memorandumContent;
	}
	/**
	 * 获取：
	 */
	public String getMemorandumContent() {
		return memorandumContent;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setCtrTime(Date ctrTime) {
		this.ctrTime = ctrTime;
	}
	/**
	 * 获取：
	 */
	public Date getCtrTime() {
		return ctrTime;
	}
}
