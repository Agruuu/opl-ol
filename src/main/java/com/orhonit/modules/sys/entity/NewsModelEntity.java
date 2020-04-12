package com.orhonit.modules.sys.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-01-11 10:27:56
 */
@TableName("tb_news_model")
public class NewsModelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer modelId;
	/**
	 * 新闻model标题
	 */
	private String modelTitle;
	/**
	 * 父级新闻model id
	 */
	@NotBlank(message="参数值不能为空")
	private Integer modelSupperId;
	
	private Integer modelType;
	
	public Integer getModelType() {
		return modelType;
	}
	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}
	/**
	 * 设置：
	 */
	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}
	/**
	 * 获取：
	 */
	public Integer getModelId() {
		return modelId;
	}
	/**
	 * 设置：新闻model标题
	 */
	public void setModelTitle(String modelTitle) {
		this.modelTitle = modelTitle;
	}
	/**
	 * 获取：新闻model标题
	 */
	public String getModelTitle() {
		return modelTitle;
	}
	/**
	 * 设置：父级新闻model标题
	 */
	public void setModelSupperId(Integer modelSupperId) {
		this.modelSupperId = modelSupperId;
	}
	/**
	 * 获取：父级新闻model标题
	 */
	public Integer getModelSupperId() {
		return modelSupperId;
	}
}
