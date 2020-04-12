package com.orhonit.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 专业表DTO
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MajorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private Integer majorId;
	/**
	 * 专业名称
	 */
	private String majorTitle;
	/**
	 * 父级id
	 */
	private Integer majorSupperId;
	private String majorSupperNot;
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

	private String areaName;

}








//	@Transient
//	private List<MajorDTO> children;

//	private int currentPage;//当前页
//	private int pageSize;//一页多少条记录
//	private int startIndex;//从哪一行开始
//	private int endIndex;//从哪一行结束
//	//根据当前所在页数和每页显示记录数计算出startIndex和endIndex
//	public void setStartIndexEndIndex(){
//		this.startIndex=(this.getCurrentPage()-1)*this.getPageSize();
//		this.endIndex= (this.getCurrentPage()-1)*this.getPageSize()+this.getPageSize();
//	}

//	/** 创建时间 */
//	@JsonSerialize(using = Date2LongSerializer.class)
//	private Date createTime;
//	/** 更新时间 */
//	@JsonSerialize(using = Date2LongSerializer.class)
//	private Date updateTime;
//}
