package com.orhonit.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 回复评论表
 * 
 * @author zjw
 * @email chobitsyjwz@163.com
 * @date 2019-01-22 14:10:06
 */
@TableName("tb_news_comment_reply")
public class AppNewsCommentReplyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论回复id
	 */
	@TableId
	private Integer replyId;
	/**
	 * 评论id
	 */
	private Integer commentId;
	/**
	 * 回复内容id
	 */
	private String replyContent;
	/**
	 * 回复人
	 */
	private Long userId;
	/**
	 * 回复谁？
	 */
	private String replyTo;
	/**
	 * 回复时间
	 */
	private Date crtTime;

	/**
	 * 设置：评论回复id
	 */
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	/**
	 * 获取：评论回复id
	 */
	public Integer getReplyId() {
		return replyId;
	}
	/**
	 * 设置：评论id
	 */
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	/**
	 * 获取：评论id
	 */
	public Integer getCommentId() {
		return commentId;
	}
	/**
	 * 设置：回复内容id
	 */
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	/**
	 * 获取：回复内容id
	 */
	public String getReplyContent() {
		return replyContent;
	}
	/**
	 * 设置：回复人
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：回复人
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：回复谁？
	 */
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
	/**
	 * 获取：回复谁？
	 */
	public String getReplyTo() {
		return replyTo;
	}
	/**
	 * 设置：回复时间
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	/**
	 * 获取：回复时间
	 */
	public Date getCrtTime() {
		return crtTime;
	}
}
