package com.orhonit.modules.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 用户支部信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-08 09:43:09
 */
@TableName("tb_user_dept")
public class UserDeptEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer deptId;
	/**
	 * 支部名称
	 */
	private String deptName;
	/**
	 * 上级支部id
	 */
	private Integer deptSupperId;
	/**
	 * 支部X坐标
	 */
	private Double deptX;
	/**
	 * 支部Y坐标
	 */
	private Double deptY;
	/**
	 * 支部介绍
	 */
	private String deptContent;
	/**
	 * 
	 */
	private Integer orgId;

	/**
	 * 设置：
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：
	 */
	public Integer getDeptId() {
		return deptId;
	}
	/**
	 * 设置：支部名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：支部名称
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置：上级支部id
	 */
	public void setDeptSupperId(Integer deptSupperId) {
		this.deptSupperId = deptSupperId;
	}
	/**
	 * 获取：上级支部id
	 */
	public Integer getDeptSupperId() {
		return deptSupperId;
	}
	/**
	 * 设置：支部X坐标
	 */
	public void setDeptX(Double deptX) {
		this.deptX = deptX;
	}
	/**
	 * 获取：支部X坐标
	 */
	public Double getDeptX() {
		return deptX;
	}
	/**
	 * 设置：支部Y坐标
	 */
	public void setDeptY(Double deptY) {
		this.deptY = deptY;
	}
	/**
	 * 获取：支部Y坐标
	 */
	public Double getDeptY() {
		return deptY;
	}
	/**
	 * 设置：支部介绍
	 */
	public void setDeptContent(String deptContent) {
		this.deptContent = deptContent;
	}
	/**
	 * 获取：支部介绍
	 */
	public String getDeptContent() {
		return deptContent;
	}
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
}
