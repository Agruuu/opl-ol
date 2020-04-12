package com.orhonit.common.converter;

import java.util.List;

/**
 * @auther:Agruuu
 * @date:2018/12/28 0028
 */
public class CommonConverter {

    /**
     * 集合数字转换成byte数组
     * @param list 数集合
     * @return
     */
    public static byte[] toByteArray(List<Integer> list) {
        if (list != null) {
            int size = list.size();
            byte[] rtn = new byte[size];
            Integer[] l = list.toArray(new Integer[size]);
            for (int i = 0; i < size; i++) {
                rtn[i] = l[i].byteValue();
            }
            return rtn;
        }
        return null;
    }
}
