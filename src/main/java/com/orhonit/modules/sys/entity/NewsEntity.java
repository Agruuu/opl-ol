package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-11 09:10:07
 */
@TableName("tb_news")
public class NewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer newId;
	/**
	 * 新闻标题
	 */
	private String newTitle;
	/**
	 * 新闻内容
	 */
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
	/**
	 * 
	 */
	private String newFromUrl;
	/**
	 * 创建人id
	 */
	private Long userId;
	/**
	 * 新闻模块
	 */
	@NotBlank(message="参数值不能为空")
	private Integer newModel;
	/**
	 * 
	 */
	@NotBlank(message="参数值不能为空")
	private Integer newSupperModel;
	/**
	 * 点击量
	 */
	private Integer newClick;

	private Integer newTopNew;
	
	private Integer newDeptId;
	
	private Integer newOrg;
	
	public Integer getNewDeptId() {
		return newDeptId;
	}
	public void setNewDeptId(Integer newDeptId) {
		this.newDeptId = newDeptId;
	}
	public Integer getNewOrg() {
		return newOrg;
	}
	public void setNewOrg(Integer newOrg) {
		this.newOrg = newOrg;
	}
	public Integer getNewTopNew() {
		return newTopNew;
	}
	public void setNewTopNew(Integer newTopNew) {
		this.newTopNew = newTopNew;
	}
	/**
	 * 设置：
	 */
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	/**
	 * 获取：
	 */
	public Integer getNewId() {
		return newId;
	}
	/**
	 * 设置：新闻标题
	 */
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	/**
	 * 获取：新闻标题
	 */
	public String getNewTitle() {
		return newTitle;
	}
	/**
	 * 设置：新闻内容
	 */
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	/**
	 * 获取：新闻内容
	 */
	public String getNewContent() {
		return newContent;
	}
	/**
	 * 设置：新闻封页图地址
	 */
	public void setNewPictureUrl(String newPictureUrl) {
		this.newPictureUrl = newPictureUrl;
	}
	/**
	 * 获取：新闻封页图地址
	 */
	public String getNewPictureUrl() {
		return newPictureUrl;
	}
	/**
	 * 设置：新闻类型：0：普通类型，1：图片新闻
	 */
	public void setNewType(Integer newType) {
		this.newType = newType;
	}
	/**
	 * 获取：新闻类型：0：普通类型，1：图片新闻
	 */
	public Integer getNewType() {
		return newType;
	}
	/**
	 * 设置：创建时间
	 */
	public void setNewCreateTime(Date newCreateTime) {
		this.newCreateTime = newCreateTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getNewCreateTime() {
		return newCreateTime;
	}
	/**
	 * 设置：新闻来源
	 */
	public void setNewFrom(String newFrom) {
		this.newFrom = newFrom;
	}
	/**
	 * 获取：新闻来源
	 */
	public String getNewFrom() {
		return newFrom;
	}
	/**
	 * 设置：
	 */
	public void setNewFromUrl(String newFromUrl) {
		this.newFromUrl = newFromUrl;
	}
	/**
	 * 获取：
	 */
	public String getNewFromUrl() {
		return newFromUrl;
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
	/**
	 * 设置：新闻模块
	 */
	public void setNewModel(Integer newModel) {
		this.newModel = newModel;
	}
	/**
	 * 获取：新闻模块
	 */
	public Integer getNewModel() {
		return newModel;
	}
	/**
	 * 设置：
	 */
	public void setNewSupperModel(Integer newSupperModel) {
		this.newSupperModel = newSupperModel;
	}
	/**
	 * 获取：
	 */
	public Integer getNewSupperModel() {
		return newSupperModel;
	}
	/**
	 * 设置：点击量
	 */
	public void setNewClick(Integer newClick) {
		this.newClick = newClick;
	}
	/**
	 * 获取：点击量
	 */
	public Integer getNewClick() {
		return newClick;
	}
}
