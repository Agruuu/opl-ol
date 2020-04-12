package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 欢迎新成员表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-28 16:30:54
 */
@TableName("tb_welcome_newp")
public class WelcomeNewpEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer newpId;
	/**
	 * 欢迎新成员标题
	 */
	@TableField(exist= false)
	private String newpTitle;
	/**
	 * 新成员id
	 */
	private Long newpUserId;
	/**
	 * 创建时间
	 */
	private Date crtTime;
	/**
	 * 阅读状态 0:未读（默认），1已读
	 */
	private Integer newpIsRead;
	/**
	 * 接收人ID
	 */
	private Long userId;
	
	@TableField(exist= false)
	private String userTrueName;
	
	
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}
	/**
	 * 设置：
	 */
	public void setNewpId(Integer newpId) {
		this.newpId = newpId;
	}
	/**
	 * 获取：
	 */
	public Integer getNewpId() {
		return newpId;
	}
	/**
	 * 设置：欢迎新成员标题
	 */
	public void setNewpTitle(String newpTitle) {
		this.newpTitle = newpTitle;
	}
	/**
	 * 获取：欢迎新成员标题
	 */
	public String getNewpTitle() {
		return newpTitle;
	}
	/**
	 * 设置：新成员id
	 */
	public void setNewpUserId(Long newpUserId) {
		this.newpUserId = newpUserId;
	}
	/**
	 * 获取：新成员id
	 */
	public Long getNewpUserId() {
		return newpUserId;
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
	 * 设置：阅读状态 0:未读（默认），1已读
	 */
	public void setNewpIsRead(Integer newpIsRead) {
		this.newpIsRead = newpIsRead;
	}
	/**
	 * 获取：阅读状态 0:未读（默认），1已读
	 */
	public Integer getNewpIsRead() {
		return newpIsRead;
	}
	/**
	 * 设置：接收人ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：接收人ID
	 */
	public Long getUserId() {
		return userId;
	}
}
