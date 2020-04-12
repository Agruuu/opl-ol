package com.orhonit.modules.app.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 新闻收藏表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-04-02 14:45:15
 */
@TableName("tb_news_collcetion")
public class NewsCollcetionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 新闻收藏表主键
	 */
	@TableId
	private Integer collcetionId;
	/**
	 * 收藏新闻id
	 */
	private Integer newId;
	/**
	 * 收藏新闻标题
	 */
	private String newTitle;
	/**
	 * 收藏人id
	 */
	private Long userId;
	/**
	 * 收藏时间
	 */
	private Long crtTime;

	/**
	 * 设置：新闻收藏表主键
	 */
	public void setCollcetionId(Integer collcetionId) {
		this.collcetionId = collcetionId;
	}
	/**
	 * 获取：新闻收藏表主键
	 */
	public Integer getCollcetionId() {
		return collcetionId;
	}
	/**
	 * 设置：收藏新闻id
	 */
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	/**
	 * 获取：收藏新闻id
	 */
	public Integer getNewId() {
		return newId;
	}
	/**
	 * 设置：收藏新闻标题
	 */
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	/**
	 * 获取：收藏新闻标题
	 */
	public String getNewTitle() {
		return newTitle;
	}
	/**
	 * 设置：收藏人id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：收藏人id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：收藏时间
	 */
	public void setCrtTime(Long crtTime) {
		this.crtTime = crtTime;
	}
	/**
	 * 获取：收藏时间
	 */
	public Long getCrtTime() {
		return crtTime;
	}
}
