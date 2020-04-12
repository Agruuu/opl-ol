package com.orhonit.common.converter;


import cn.hutool.core.util.StrUtil;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther:Agruuu
 * @date:2018/12/28 0028
 */
public class ConverterForTree {
    /**
     * 将 含 tree 格式的列表数据，转化成 tree 格式 tree 格式的列表数据格式为含有 主id 和 父id 的数据格式
     *
     * @param: list
     * @param: idField,主id属性名
     * @param: pidField,父id属性名
     * @param: pkField
     *            GlobalsName.FIELD_SYSID
     * @param: labelField,tree
     *            需要显示的 label 字段名称
     * @return: List<Map<String,Object>>
     */
    public static List<Map<String, Object>> list2Tree(List list, String pidField, String pkField, String refId) {
        return list2Tree(list, pidField, pkField, null, refId);
    }

    /**
     * 将 含 tree 格式的列表数据，转化成 tree 格式 tree 格式的列表数据格式为含有 主id 和 父id 的数据格式
     *
     * @param: list
     * @param: idField,主id属性名
     * @param: pidField,父id属性名
     * @param: pkField
     *            GlobalsName.FIELD_SYSID
     * @param: labelField,tree
     *            需要显示的 label 字段名称
     * @param: handle
     *            AppUtil.List2Tree
     * @return: List<Map<String,Object>>
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static List<Map<String, Object>> list2Tree(List list, String pidField, String pkField, List2Tree handle,
                                                      String refId) {
        Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
        List<Map<String, Object>> firstGradeList = new ArrayList<Map<String, Object>>();
        Map<String,Object> tempMap=new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> obj = null;
            if (list.get(i) instanceof Map) {
                obj = ((Map<String, Object>) list.get(i));
            } else {
                obj = (Map<String, Object>) bean2Map(list.get(i));
            }
            if (map.get(obj.get(pidField) + "") == null) {
                List<Map<String, Object>> sub = new ArrayList<Map<String, Object>>();
                sub.add(obj);
                map.put(obj.get(pidField) + "", sub);
            } else {
                map.get(obj.get(pidField) + "").add(obj);
            }
            if (handle == null) {
                if (obj.get(pidField) == null || "-1".equals(obj.get(pidField)) || "".equals(obj.get(pidField))
                        || "0".equals(obj.get(pidField).toString())
                        || (StrUtil.isNotEmpty(refId) && refId.equals(obj.get("refId").toString()))) {
                    if(StrUtil.isNotEmpty(refId)){
                        tempMap.put(obj.get(pkField).toString(), obj);
                        if(!StringUtils.isEmpty(obj.get(pidField))&&!tempMap.containsKey(obj.get(pidField).toString())){
                            firstGradeList.add(obj);
                        }
                    }else{
                        firstGradeList.add(obj);
                    }
                } else {
                    firstGradeList.add(obj);
                }
            } else {
                if (handle.isFirstNode(obj)) {
                    firstGradeList.add(obj);
                }
            }
        }
        iterableList(firstGradeList, map, pkField);
        return firstGradeList;
    }

    private static void iterableList(List<Map<String, Object>> firstGradeList,
                                     Map<String, List<Map<String, Object>>> map, String pkField) {
        for (Map<String, Object> m : firstGradeList) {
            List<Map<String, Object>> sublist = map.remove(m.get(pkField) + "");
            if (sublist != null) {
                m.put("children", sublist);
                iterableList(sublist, map, pkField);
            }
        }
    }

    /**
     * 将 JavaBean 对象转化成 BasicMap 对象
     *
     * @param: javaBean
     * @return:
     */
    public static Map<String, Object> bean2Map(Object javaBean) {
        Map<String, Object> rtn = new HashMap<String, Object>();
        if (javaBean != null) {
            Method[] ms = javaBean.getClass().getMethods();
            for (Method m : ms) {
                if (!"getClass".equals(m.getName()) && m.getName().matches("get.*")
                        && m.getTypeParameters().length == 0) {
                    Object obj = null;
                    try {
                        obj = m.invoke(javaBean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    rtn.put(m.getName().replace("get", "").toLowerCase(), obj);
                }
            }
        }
        return rtn;
    }

    /**
     * 将Tree格式数据（含有children Key）转换成List，并生成代理主键及父子关系
     *
     * @param: tablename
     *            存储tree数据的表的名字
     * @param: treeFormat
     *            tree 格式数据，从页面传递过来的数据
     * @param: pidField
     *            父编码字段
     * @param: pkField
     *            GlobalsName.FIELD_SYSID
     * @param: sortField
     *            排序字段
     * @param: tree2List
     *            AppUtil.Tree2List
     * @return: 返回 List<Map<String,Object>> 类型
     * @throws:
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> tree2List(List<? extends Map<String, Object>> treeFormat, String pidField,
                                                      String pkField, String sortField, String gradeField) throws Exception {
        return tree2List(treeFormat, pidField, pkField, sortField, gradeField, null);
    }

    /**
     * 将Tree格式数据（含有children Key）转换成List，并生成代理主键及父子关系
     *
     * @param: tablename
     *            存储tree数据的表的名字
     * @param: treeFormat
     *            tree 格式数据，从页面传递过来的数据
     * @param: pidField
     *            父编码字段
     * @param: pkField
     *            GlobalsName.FIELD_SYSID
     * @param: sortField
     *            排序字段
     * @param: tree2List
     *            AppUtil.Tree2List
     * @return: 返回 List<Map<String,Object>> 类型
     * @throws: AppException
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> tree2List(List<? extends Map<String, Object>> treeFormat, String pidField,
                                                      String pkField, String sortField, String gradeField, Tree2List tree2List) throws Exception {
        List<Map<String, Object>> rtn = new ArrayList<Map<String, Object>>();
        if (treeFormat != null) {
            int sortValue = 1;
            for (Map<String, Object> map : treeFormat) {
                /*
                 * 一级节点pid 为 null，无数据 if(!"puid".equals(pidField)){
                 * map.put(pidField, -1); }
                 */
                if (sortField != null) {
                    map.put(sortField, sortValue);
                    sortValue++;
                }
                if (gradeField != null) {
                    map.put(gradeField, 1);
                }
                rtn.add(map);

                /*
                 * map.put("lft", 1); map.put("rgt", 2);
                 */

                iterableList(rtn, map, pidField, pkField, sortField, gradeField, 2, tree2List);
            }
        }
        return rtn;
    }

    @SuppressWarnings({ "unchecked" })
    private static void iterableList(List<Map<String, Object>> list, Map<String, Object> firstMap, String pidField,
                                     String pkField, String sortField, String gradeField, Integer grade, Tree2List tree2List) throws Exception {
        Object obj = firstMap.remove("children");
        if (obj != null && obj instanceof List) {
            List<Map<String, Object>> children = (List<Map<String, Object>>) obj;
            if (children != null && !children.isEmpty()) {
                int sortValue = 101;
                for (Map<String, Object> m : children) {
                    if (tree2List != null) {
                        tree2List.processData(firstMap, m);
                    }
                    if (sortField != null) {
                        m.put(sortField, sortValue);
                        sortValue++;
                    }
                    if (gradeField != null) {
                        m.put(gradeField, grade);
                    }

                    /*
                     * if(firstMap.get("lft")!=null){ m.put("lft",
                     * AppUtil.toInteger(firstMap.get("lft")) + 1); }
                     */

                    m.put(pidField, firstMap.get(pkField));
                    list.add(m);
                    Integer l = 2;
                    if (gradeField != null) {
                        l = (Integer) m.get(gradeField);
                    }
                    iterableList(list, m, pidField, pkField, sortField, gradeField, ++l, tree2List);
                }
            } else {
                // firstMap.put("leaf", true);
                if (tree2List != null) {
                    tree2List.processData(firstMap, null);
                }
            }
        } else {
            // firstMap.put("leaf", true);
            if (tree2List != null) {
                tree2List.processData(firstMap, null);
            }
        }
    }

    /**
     * list2tree 接口判断
     */
    public static interface List2Tree {
        boolean isFirstNode(Map<String, Object> obj);
    }

    /**
     * tree2list 扩展接口
     */
    public static interface Tree2List {
        void processData(Map<String, Object> parent, Map<String, Object> child);
    }

    public static interface GroupHandle {
        /**
         * 处理每组数据的 List 为横向数据
         *
         * @param list
         *            每一组中的数据（ groupField 组中的数据列表）
         * @param data
         *            最终形成的横向数据
         */
        void processData(List<Map<String, Object>> list, Map<String, Object> data);

        /**
         * 处理分组的 key 数据
         */
        Object processGroupKey(Object groupKey);

    }
}
