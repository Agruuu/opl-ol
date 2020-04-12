package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-14 11:09:47
 */
@TableName("tb_news_lbt")
public class NewsLbtEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer lbtId;
	/**
	 * 轮播图介绍（不能超过200字）
	 */
	private String lbtTitle;
	/**
	 * 图片地址（符号加字符不能超过255）
	 */
	private String lbtPicurl;
	/**
	 * 排序（最大9999）
	 */
	private Integer lbtSort;
	/**
	 * 创建时间
	 */
	private Date crtTime;
	/**
	 * 创建人id
	 */
	private Long userId;

	/**
	 * 设置：id
	 */
	public void setLbtId(Integer lbtId) {
		this.lbtId = lbtId;
	}
	/**
	 * 获取：id
	 */
	public Integer getLbtId() {
		return lbtId;
	}
	/**
	 * 设置：轮播图介绍（不能超过200字）
	 */
	public void setLbtTitle(String lbtTitle) {
		this.lbtTitle = lbtTitle;
	}
	/**
	 * 获取：轮播图介绍（不能超过200字）
	 */
	public String getLbtTitle() {
		return lbtTitle;
	}
	/**
	 * 设置：图片地址（符号加字符不能超过255）
	 */
	public void setLbtPicurl(String lbtPicurl) {
		this.lbtPicurl = lbtPicurl;
	}
	/**
	 * 获取：图片地址（符号加字符不能超过255）
	 */
	public String getLbtPicurl() {
		return lbtPicurl;
	}
	/**
	 * 设置：排序（最大9999）
	 */
	public void setLbtSort(Integer lbtSort) {
		this.lbtSort = lbtSort;
	}
	/**
	 * 获取：排序（最大9999）
	 */
	public Integer getLbtSort() {
		return lbtSort;
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
	 * 设置：创建人id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：创建人id
	 */
	public Long getUserId() {
		return userId;
	}
}
