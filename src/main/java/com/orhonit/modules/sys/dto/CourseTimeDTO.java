package com.orhonit.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * 课程时间
 * @auther:Agruuu
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseTimeDTO {

    /**
     * 课程日期
     */
    private Date courseDate;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
    private Integer credit;
}
