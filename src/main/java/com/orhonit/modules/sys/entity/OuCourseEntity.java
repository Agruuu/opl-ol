package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.Generated;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-02-14 18:38:11
 */
@Data
@TableName("tb_ou_course")
public class OuCourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer courseId;
	/**
	 * 课程名
	 */
	private String courseName;
	/**
	 * 课程介绍
	 */
	private String courseContent;
	/**
	 * 专业id
	 */
	private Integer courseMajorId;
	/**
	 * 地区id
	 */
	private String courseAreaId;
	/**
	 * 教师id
	 */
	private Integer courseTeacherId;
	/**
	 * 教师简介
	 */
	private String courseTeacherContent;
	/**
	 * 详细上课地址
	 */
	private String courseAddress;
	/**
	 * 报名人数
	 */
	private Integer courseSignNum;
	/**
	 * 总课时
	 */
	private Integer courseHours;
	/**
	 * 是否开启报名(Y 开启，N关闭)
	 */
	private String courseSignOpen;
	/**
	 * 是否精品课程(0 普通，1 精品)
	 */
	private String courseCompetitive;
	/**
	 * 是否可用(Y 可用，N 不可用，D 已删)
	 */
	private String courseIsUse;
	/**
	 * 图片地址
	 */
	private String coursePictureUrl;
}
