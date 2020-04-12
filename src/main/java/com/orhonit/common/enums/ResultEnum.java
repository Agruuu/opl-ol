package com.orhonit.common.enums;

import lombok.Getter;

/**
 * @auther:Agruuu
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(0001, "参数不正确"),
    PARAM_NOT_NULL(0002, "参数不能为空"),
    DEPT_NOT_EXIST(1001, "支部不存在"),
    MAJOR_SAVE_ERROR(3001, "专业添加失败"),
    MAJOR_UPD_ERROR(3002, "专业修改失败"),
    TEACHER_SAVE_ERROR(3003, "教师添加失败"),
    TEACHER_UPD_ERROR(3004, "教师修改失败"),
    TEACHER_DEL_ERROR(3005, "教师删除失败"),
    COURSE_SAVE_ERROR(3006, "课程添加失败"),
    COURSE_TIME_SAVE_ERROR(3007, "课程时间添加失败"),
    COURSE_UPDATE_ERROR(3008, "课程修改失败"),
    COURSE_TIME_UPDATE_ERROR(3009, "课程时间修改失败"),
    COURSE_DELETE_ERROR(3010, "课程删除失败"),
    COURSE_TIME_DELETE_ERROR(3011, "课程时间删除失败"),

    COURSE_SIGNUP_ERROR(3012, "课程报名失败"),
    COURSE_COMMENT_ADD_ERROR(3013, "课程评论失败")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
