package com.orhonit.modules.app.vo;

import java.io.Serializable;
import java.util.Date;

public class AppNewsListVo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Integer newId;
	/**
	 * 新闻标题
	 */
	private String newTitle;
	
	private String newContent;
	/**
	 * 新闻封页图地址
	 */
	private String newPictureUrl;
	/**
	 * 新闻类型：0：普通类型，1：图片新闻
	 */
	private Integer newType;
	/**
	 * 创建时间
	 */
	private Date newCreateTime;
	/**
	 * 新闻来源
	 */
	private String newFrom;
	
	private String newFromUrl;
	/**
	 * 点击量
	 */
	private Integer newClick;
	
	private Integer newTopNew;
	
	
	public String getNewContent() {
		return newContent;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public Integer getNewId() {
		return newId;
	}

	public void setNewId(Integer newId) {
		this.newId = newId;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewPictureUrl() {
		return newPictureUrl;
	}

	public void setNewPictureUrl(String newPictureUrl) {
		this.newPictureUrl = newPictureUrl;
	}

	public Integer getNewType() {
		return newType;
	}

	public void setNewType(Integer newType) {
		this.newType = newType;
	}

	public Date getNewCreateTime() {
		return newCreateTime;
	}

	public void setNewCreateTime(Date newCreateTime) {
		this.newCreateTime = newCreateTime;
	}

	public String getNewFrom() {
		return newFrom;
	}

	public void setNewFrom(String newFrom) {
		this.newFrom = newFrom;
	}

	public String getNewFromUrl() {
		return newFromUrl;
	}

	public void setNewFromUrl(String newFromUrl) {
		this.newFromUrl = newFromUrl;
	}

	public Integer getNewClick() {
		return newClick;
	}

	public void setNewClick(Integer newClick) {
		this.newClick = newClick;
	}

	public Integer getNewTopNew() {
		return newTopNew;
	}

	public void setNewTopNew(Integer newTopNew) {
		this.newTopNew = newTopNew;
	}
	
}
	
