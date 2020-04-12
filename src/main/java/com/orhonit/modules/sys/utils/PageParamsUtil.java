package com.orhonit.modules.sys.utils;

import java.util.Map;

/**
 * @auther:Agruuu
 * @date:2019/1/21 0021
 */
public class PageParamsUtil {

    public static Map<String, Object> getLimit(Map<String, Object> params) {
        int pageSize = 20;
        int currentPage = Integer.parseInt(params.get("currentPage").toString());
        int startIndex = (currentPage-1) * pageSize;
        params.put("startRecord", startIndex);
        params.put("length", pageSize);
        return params;
    }

    public static Map<String, Object> getLimitWeb(Map<String, Object> params) {
        int pageSize = 10;
        int currentPage = Integer.parseInt(params.get("currentPage").toString());
        int startIndex = (currentPage-1) * pageSize;
        params.put("startRecord", startIndex);
        params.put("length", pageSize);
        return params;
    }
}
