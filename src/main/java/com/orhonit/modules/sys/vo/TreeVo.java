package com.orhonit.modules.sys.vo;

import java.util.List;
/**
 * 树型结构实体类
 * @author ds2307813
 *
 */
public class TreeVo {
	
	private Integer treeId;
	private String treeName;
	private Integer supperTreeId;
	private List<TreeVo> ChildList;
	
	public Integer getSupperTreeId() {
		return supperTreeId;
	}
	public void setSupperTreeId(Integer supperTreeId) {
		this.supperTreeId = supperTreeId;
	}
	public List<TreeVo> getChildList() {
		return ChildList;
	}
	public void setChildList(List<TreeVo> childList) {
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
