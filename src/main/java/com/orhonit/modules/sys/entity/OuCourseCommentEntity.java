package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程评价
 */
@Data
@TableName("tb_ou_course_comment")
public class OuCourseCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer commId;
	/**
	 * 课程id
	 */
	private Integer commCourseId;
	/**
	 * 用户id
	 */
	private Integer commUserId;
	/**
	 * 评价内容
	 */
	private String commContent;
	/**
	 * 课程评分
	 */
	private Integer commScore;
	/**
	 * 是否匿名评价(Y 是， N否)
	 */
	private String commAnonymous;
	/**
	 * 图片地址
	 */
	private String commPictureUrl;

	/**
	 * 删除表示（Y 可用， D已删除）
	 */
	private String commIsUse;

	/**
	 * 评论时间
	 */
	private Date commDate;
}
