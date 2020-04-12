package com.orhonit.common.interfac;

import java.util.List;

/**
 * 树形数据实体接口 
 * @author YangWenHui
 * @date 2018年4月11
 * @param <T>
 */
public interface dataTree<T> {
	
	public String getId();
	
    public String getParentId();
    
    public void setChildList(List<T> childList);
    
    public List<T> getChildList();
}
