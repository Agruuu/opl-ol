package com.orhonit.modules.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 字典表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-28 11:47:36
 */
@TableName("sys_dict")
public class SysDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long dictId;
	/**
	 * 类型
	 */
	private String dictType;
	/**
	 * 识别码
	 */
	private Integer dictCode;
	/**
	 * 标题
	 */
	private String dictName;

	/**
	 * 设置：
	 */
	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}
	/**
	 * 获取：
	 */
	public Long getDictId() {
		return dictId;
	}
	/**
	 * 设置：类型
	 */
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	/**
	 * 获取：类型
	 */
	public String getDictType() {
		return dictType;
	}
	/**
	 * 设置：识别码
	 */
	public void setDictCode(Integer dictCode) {
		this.dictCode = dictCode;
	}
	/**
	 * 获取：识别码
	 */
	public Integer getDictCode() {
		return dictCode;
	}
	/**
	 * 设置：标题
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	/**
	 * 获取：标题
	 */
	public String getDictName() {
		return dictName;
	}
}
