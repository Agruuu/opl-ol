package com.orhonit.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-01-23 14:34:36
 */
@TableName("tb_news_thumbsup")
public class AppNewsThumbsupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer thumbsupId;
	/**
	 * 用户id
	 */
	private Long userId;
	/**
	 * 新闻id
	 */
	private Integer newId;

	/**
	 * 设置：
	 */
	public void setThumbsupId(Integer thumbsupId) {
		this.thumbsupId = thumbsupId;
	}
	/**
	 * 获取：
	 */
	public Integer getThumbsupId() {
		return thumbsupId;
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
	 * 设置：新闻id
	 */
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	/**
	 * 获取：新闻id
	 */
	public Integer getNewId() {
		return newId;
	}
}
