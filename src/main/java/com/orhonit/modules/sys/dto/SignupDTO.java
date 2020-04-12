package com.orhonit.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程报名
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignupDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer signId;
	/**
	 * 课程id
	 */
	private Integer signCourseId;

	/**
	 * 课程名称
	 */
	private String signCourseName;

	/**
	 * 用户id
	 */
	private Integer signUserId;

	/**
	 * 用户名称
	 */
	private String signUserName;

	/**
	 * 报名时间
	 */
	private Date signDate;
}
