/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.orhonit.modules.app.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-27 10:38:42
 */
@TableName("sys_user")
public class AppUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	//真实姓名
	private String userTrueName;
	/**
	 * 用户昵称
	 */
	private String userNickname;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别：0：男，1：女
	 */
	private Integer userSex;
	/**
	 * 民族：0
	 */
	private Integer userRace;
	/**
	 * 生日
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
	private Date userBirthday;
	/**
	 * 头像地址
	 */
	private String userHeadPicture;
	/**
	 * 所在支部
	 */
	private Integer userDept;
	/**
	 * 所在单位
	 */
	private Integer userOrg;
	/**
	 * 用户职务或退休前职务
	 */
	private String userWork;
	/**
	 * 是否是党员
	 */
	private Integer isPartyMember;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 用户所在地区编码
	 */
	private String userArea;
	/**
	 * 
	 */
	private Double userAddressX;
	/**
	 * 
	 */
	private Double userAddressY;
	/**
	 * 
	 */
	private Integer userPartyPosts;	
	/**
	 * 盐
	 */
	private String salt;
	
	public String getUserTrueName() {
		return userTrueName;
	}
	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public Integer getUserRace() {
		return userRace;
	}
	public void setUserRace(Integer userRace) {
		this.userRace = userRace;
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserHeadPicture() {
		return userHeadPicture;
	}
	public void setUserHeadPicture(String userHeadPicture) {
		this.userHeadPicture = userHeadPicture;
	}
	public Integer getUserDept() {
		return userDept;
	}
	public void setUserDept(Integer userDept) {
		this.userDept = userDept;
	}
	public Integer getUserOrg() {
		return userOrg;
	}
	public void setUserOrg(Integer userOrg) {
		this.userOrg = userOrg;
	}
	public String getUserWork() {
		return userWork;
	}
	public void setUserWork(String userWork) {
		this.userWork = userWork;
	}
	public Integer getIsPartyMember() {
		return isPartyMember;
	}
	public void setIsPartyMember(Integer isPartyMember) {
		this.isPartyMember = isPartyMember;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserArea() {
		return userArea;
	}
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}
	public Double getUserAddressX() {
		return userAddressX;
	}
	public void setUserAddressX(Double userAddressX) {
		this.userAddressX = userAddressX;
	}
	public Double getUserAddressY() {
		return userAddressY;
	}
	public void setUserAddressY(Double userAddressY) {
		this.userAddressY = userAddressY;
	}
	public Integer getUserPartyPosts() {
		return userPartyPosts;
	}
	public void setUserPartyPosts(Integer userPartyPosts) {
		this.userPartyPosts = userPartyPosts;
	}

	
}
