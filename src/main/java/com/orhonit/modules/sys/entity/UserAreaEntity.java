package com.orhonit.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 地区
 */
@Data
@TableName("tb_user_area")
public class UserAreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 区域id
	 */
	@TableId
	private String id;
	/**
	 * 区域名称
	 */
	private String name;
}
