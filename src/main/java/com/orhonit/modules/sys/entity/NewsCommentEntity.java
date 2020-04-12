package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻评论表
 * 
 * @author zjw
 * @email sunlightcs@gmail.com
 * @date 2019-01-15 09:58:02
 */
@TableName("tb_news_comment")
public class NewsCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论id
	 */
	@TableId
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
	 * 评论人姓名
	 */
	@TableField(exist=false)
	private String userNickName;
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
	
	public Integer getCommentReplyCount() {
		return commentReplyCount;
	}
	public void setCommentReplyCount(Integer commentReplyCount) {
		this.commentReplyCount = commentReplyCount;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
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
	 * 设置：评论内容
	 */
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	/**
	 * 获取：评论内容
	 */
	public String getCommentContent() {
		return commentContent;
	}
	/**
	 * 设置：评论人id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：评论人id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：被评论新闻id
	 */
	public void setNewId(Integer newId) {
		this.newId = newId;
	}
	/**
	 * 获取：被评论新闻id
	 */
	public Integer getNewId() {
		return newId;
	}
	/**
	 * 设置：评论填写时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：评论填写时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
