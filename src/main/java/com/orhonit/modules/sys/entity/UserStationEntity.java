package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户车站表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-02-13 10:14:11
 */
@TableName("tb_user_station")
public class UserStationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 车站id
	 */
	@TableId
	private Integer stationId;
	/**
	 * 车站名
	 */
	private String stationName;
	/**
	 * 站点顺序
	 */
	private Integer stationSort;
	/**
	 * 站点所属线路
	 */
	private Integer routeId;
	
	/**
	 * 到站时间
	 */
	private Date stationArrivalTime;
	

	public Date getStationArrivalTime() {
		return stationArrivalTime;
	}
	public void setStationArrivalTime(Date stationArrivalTime) {
		this.stationArrivalTime = stationArrivalTime;
	}
	/**
	 * 设置：车站id
	 */
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	/**
	 * 获取：车站id
	 */
	public Integer getStationId() {
		return stationId;
	}
	/**
	 * 设置：车站名
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	/**
	 * 获取：车站名
	 */
	public String getStationName() {
		return stationName;
	}
	/**
	 * 设置：站点顺序
	 */
	public void setStationSort(Integer stationSort) {
		this.stationSort = stationSort;
	}
	/**
	 * 获取：站点顺序
	 */
	public Integer getStationSort() {
		return stationSort;
	}
	/**
	 * 设置：站点所属线路
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	/**
	 * 获取：站点所属线路
	 */
	public Integer getRouteId() {
		return routeId;
	}
}
