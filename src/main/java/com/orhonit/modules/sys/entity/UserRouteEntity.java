package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

/**
 * 乘车路线表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-11 17:21:10
 */
@TableName("tb_user_route")
public class UserRouteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer routeId;
	/**
	 * 路线名称
	 */
	private String routeName;
	/**
	 * 所属支部id
	 */
	@NotBlank(message="参数值不能为空")
	private Integer deptId;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date crtTime;

	/**
	 * 设置：
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	/**
	 * 获取：
	 */
	public Integer getRouteId() {
		return routeId;
	}
	/**
	 * 设置：路线名称
	 */
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	/**
	 * 获取：路线名称
	 */
	public String getRouteName() {
		return routeName;
	}
	/**
	 * 设置：所属支部id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：所属支部id
	 */
	public Integer getDeptId() {
		return deptId;
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
}
