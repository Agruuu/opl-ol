package com.orhonit.modules.app.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class AppNewsCommentVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer commentId;
	/**
	 * 评论内容
	 */
	private String commentContent;
	
	/**
	 * 评论人id
	 */
	private Long userId;
	/**
	 * 被评论新闻id
	 */
	private Integer newId;
	/**
	 * 评论填写时间
	 */
	private Date createTime;
	/**
	 * 回复数量
	 */
	private Integer commentReplyCount;
	
	private String commentCrtName;
	
	private List<AppNewsComReplyVo> appNewsComReplyVo;
	
	
	public Integer getCommentReplyCount() {
		return commentReplyCount;
	}
	public void setCommentReplyCount(Integer commentReplyCount) {
		this.commentReplyCount = commentReplyCount;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public List<AppNewsComReplyVo> getAppNewsComReplyVo() {
		return appNewsComReplyVo;
	}
	public void setAppNewsComReplyVo(List<AppNewsComReplyVo> appNewsComReplyVo) {
		this.appNewsComReplyVo = appNewsComReplyVo;
	}
	public String getCommentCrtName() {
		return commentCrtName;
	}
	public void setCommentCrtName(String commentCrtName) {
		this.commentCrtName = commentCrtName;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getNewId() {
		return newId;
	}
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
