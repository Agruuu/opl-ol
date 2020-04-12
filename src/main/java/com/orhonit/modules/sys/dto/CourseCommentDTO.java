package com.orhonit.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 课程评价
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseCommentDTO {

	/**
	 * 主键
	 */
	private Integer commId;
	/**
	 * 课程id
	 */
	private Integer commCourseId;
	private String commCourseName;
	/**
	 * 用户id
	 */
	private Integer commUserId;
	private String commUserName;
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
	private String commPictureUrls;

	/**
	 * 评论时间
	 */
	private Date commDate;
	/**
	 * 图片地址数组
	 */
	private String[] commPictureUrl;
	/**
	 * 用户头像
	 */
	private String commUserPictureUrl;
}
