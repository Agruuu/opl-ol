package com.orhonit.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 教师
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer teacherId;
	/**
	 * 教师姓名
	 */
	private String teacherName;
	/**
	 * 专业id
	 */
	private Integer teacherMajorId;
	private String teacherMajorTitle;

	/**
	 * 地区id
	 */
	private String teacherAreaId;
	private String teacherAreaName;
	/**
	 * 性别
	 */
	private Integer teacherSex;
	/**
	 * 年龄
	 */
	private Integer teacherAge;
	/**
	 * 身份证号
	 */
	private String teacherIdentity;
	/**
	 * 教学课程
	 */
	private String teacherCourse;
	/**
	 * 经验
	 */
	private String teacherExperience;
	/**
	 * 证书
	 */
	private String teacherCertificate;
	/**
	 * 教师简介
	 */
	private String teacherContent;
	/**
	 * 附件
	 */
	private String teacherEnclosure;
	/**
	 *
	 */
	private String teacherPictureUrl;
	/**
	 * 是否可用(Y/N)
	 */
	private String teacherState;
}
