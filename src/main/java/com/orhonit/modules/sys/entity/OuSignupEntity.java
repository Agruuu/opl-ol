package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程报名
 */
@TableName("tb_ou_signup")
@Data
public class OuSignupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer signId;
	/**
	 * 课程id
	 */
	private Integer signCourseId;
	/**
	 * 用户id
	 */
	private Integer signUserId;
	/**
	 * 报名时间
	 */
	private Date signDate;
}
