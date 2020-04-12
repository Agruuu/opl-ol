package com.orhonit.modules.sys.vo;

import java.util.List;
/**
 * 树型结构实体类
 * @author ds2307813
 *
 */
public class NewsModelTreeVo {
	
	private Integer treeId;
	private String treeName;
	private Integer supperTreeId;
	private Integer treeType;
	private List<NewsModelTreeVo> ChildList;
	
	public Integer getTreeType() {
		return treeType;
	}
	public void setTreeType(Integer treeType) {
		this.treeType = treeType;
	}
	public Integer getSupperTreeId() {
		return supperTreeId;
	}
	public void setSupperTreeId(Integer supperTreeId) {
		this.supperTreeId = supperTreeId;
	}
	public List<NewsModelTreeVo> getChildList() {
		return ChildList;
	}
	public void setChildList(List<NewsModelTreeVo> childList) {
		ChildList = childList;
	}
	public Integer getTreeId() {
		return treeId;
	}
	public void setTreeId(Integer treeId) {
		this.treeId = treeId;
	}
	public String getTreeName() {
		return treeName;
	}
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}

}
