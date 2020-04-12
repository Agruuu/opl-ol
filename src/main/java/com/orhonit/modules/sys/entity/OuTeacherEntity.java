package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 教师表
 */
@TableName("tb_ou_teacher")
@Data
public class OuTeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId
	private Integer teacherId;
	/**
	 * 教师姓名
	 */
	private String teacherName;
	/**
	 * 专业id
	 */
	private Integer teacherMajorId;
	/**
	 * 地区id
	 */
	private String teacherAreaId;
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
