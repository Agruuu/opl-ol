package com.orhonit.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 课程信息
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//	@JsonSerialize(using = Date2LongSerializer.class)
public class CourseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
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
	private String courseMajorTitle;
	/**
	 * 地区id
	 */
	private String courseAreaId;
	private String courseAreaName;
	/**
	 * 教师id
	 */
	private Integer courseTeacherId;
	private String courseTeacherName;
	/**
	 * 教师简介
	 */
	private String courseTeacherContent;
	/**
	 * 
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
	/**
	 * 报名日期
	 */
	private Date courseSignDate;

	/** 周几 */
	private Integer weekday;
	/** 时段（AM 上午，PM 下午） */
	private String period;

//	private List<CourseTimeDTO> courseTimeDTOList;
	private List<CourseScheduleDTO> courseTime;
	private List<CourseCommentDTO> courseComment;
}
