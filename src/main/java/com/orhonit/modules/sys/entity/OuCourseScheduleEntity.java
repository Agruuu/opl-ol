package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程时间表
 */
@Data
@TableName("tb_ou_course_schedule")
public class OuCourseScheduleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer ctId;
	/**
	 * 课程id
	 */
	private Integer ctCourseId;
	/**
	 * 教师id
	 */
	private Integer ctTeacherId;
	/**
	 * 上课日期
	 */
	private Date ctCourseDate;
	/**
	 * 上课时间(格式：09:00:00)
	 */
	private String ctStartTime;
	/**
	 * 下课时间(格式：09:00:00)
	 */
	private String ctEndTime;
	/**
	 * 上下午(AM 上午，PM 下午)
	 */
	// private String ctPeriod;
	/**
	 * 学分
	 */
	private Integer ctCredit;

	private String ctIsUse;
}
