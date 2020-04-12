package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 专业表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-16 15:11:44
 */
@TableName("tb_ou_major")
@Data
@SuppressWarnings("unchecked")
public class OuMajorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer majorId;
	/**
	 * 专业名称
	 */
	private String majorTitle;
	/**
	 * 父级id
	 */
	private Integer majorSupperId;
	/**
	 * 专业介绍
	 */
	private String majorContent;
	/**
	 * 是否可用
	 */
	private String majorIsUse;
	/**
	 * 地区id
	 */
	private String areaId;
}
