package com.orhonit.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 拆分工具类
 * @author 	cyf
 * @date	2018/11/05 下午7:45:41
 */
public class SplitUtils {
	
	
	/**
	 * 将ids字符串按照separator拆分为List<String>集合
	 * @param ids
	 * @param separator
	 * @return
	 */
	public static List<Long> splitIds(String ids,String separator) {
		String[] split = ids.split(separator);
		List<Long> list=new ArrayList<>();
		for (String id : split) {
			list.add(Long.parseLong(id));
		}
		return list;
	}

}
