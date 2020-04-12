package com.orhonit.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程时间表
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseScheduleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer ctId;
	/**
	 * 课程id
	 */
	private Integer ctCourseId;
	private String ctCourseName;
	/**
	 * 教师id
	 */
	private Integer ctTeacherId;
	private String ctTeacherName;
	/**
	 * 上课日期
	 */
	private String ctCourseDate;
//	private String ctCourseDateStr;
	/**
	 * 上课时间(格式：09:00:00)
	 */
	private String ctStartTime;
	/**
	 * 下课时间(格式：09:00:00)
	 */
	private String ctEndTime;
	/**
	 * 学分
	 */
	private Integer ctCredit;
	/**
	 * 周几
	 */
	private Integer ctDayOfWeek;
	/**
	 * 上下午(AM 上午，PM 下午)
	 */
	private String ctPeriod;

	private String ctIsUse;
}
