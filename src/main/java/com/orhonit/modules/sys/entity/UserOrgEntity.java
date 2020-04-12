package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * app用户所在单位表
 * 
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-14 16:29:13
 */
@TableName("tb_user_org")
public class UserOrgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer orgId;
	/**
	 * 单位名称
	 */
	private String orgName;
	/**
	 * 上级单位id
	 */
	private Integer orgSupperId;
	/**
	 * 所在位置X坐标
	 */
	private Double orgX;
	/**
	 * 所在位置Y坐标
	 */
	private Double orgY;
	/**
	 * 
	 */
	private String orgContent;

	/**
	 * 设置：
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：
	 */
	public Integer getOrgId() {
		return orgId;
	}
	/**
	 * 设置：单位名称
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * 获取：单位名称
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * 设置：上级单位id
	 */
	public void setOrgSupperId(Integer orgSupperId) {
		this.orgSupperId = orgSupperId;
	}
	/**
	 * 获取：上级单位id
	 */
	public Integer getOrgSupperId() {
		return orgSupperId;
	}
	/**
	 * 设置：所在位置X坐标
	 */
	public void setOrgX(Double orgX) {
		this.orgX = orgX;
	}
	/**
	 * 获取：所在位置X坐标
	 */
	public Double getOrgX() {
		return orgX;
	}
	/**
	 * 设置：所在位置Y坐标
	 */
	public void setOrgY(Double orgY) {
		this.orgY = orgY;
	}
	/**
	 * 获取：所在位置Y坐标
	 */
	public Double getOrgY() {
		return orgY;
	}
	/**
	 * 设置：
	 */
	public void setOrgContent(String orgContent) {
		this.orgContent = orgContent;
	}
	/**
	 * 获取：
	 */
	public String getOrgContent() {
		return orgContent;
	}
}
