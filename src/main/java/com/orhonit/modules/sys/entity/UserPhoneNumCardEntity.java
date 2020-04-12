package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户手机识别码表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-03-04 10:13:59
 */
@TableName("tb_user_phone_num_card")
public class UserPhoneNumCardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer phoneId;
	/**
	 * 设备识别码
	 */
	private String phoneNumCard;
	/**
	 * 用户支部id
	 */
	private Integer deptId;
	/**
	 * 用户单位id
	 */
	private Integer orgId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 用户所在地区id
	 */
	private String areaId;

	/**
	 * 设置：
	 */
	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}
	/**
	 * 获取：
	 */
	public Integer getPhoneId() {
		return phoneId;
	}
	/**
	 * 设置：设备识别码
	 */
	public void setPhoneNumCard(String phoneNumCard) {
		this.phoneNumCard = phoneNumCard;
	}
	/**
	 * 获取：设备识别码
	 */
	public String getPhoneNumCard() {
		return phoneNumCard;
	}
	/**
	 * 设置：用户支部id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：用户支部id
	 */
	public Integer getDeptId() {
		return deptId;
	}
	/**
	 * 设置：用户单位id
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：用户单位id
	 */
	public Integer getOrgId() {
		return orgId;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户所在地区id
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：用户所在地区id
	 */
	public String getAreaId() {
		return areaId;
	}
}
