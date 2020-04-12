package com.orhonit.modules.sys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther:Agruuu
 * @date:2019/1/23 0023
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseForWeekDTO {

    /**
     * 周几
     */
    private Integer dayOfWeek;
    /**
     * 上午还是下午
     */
    private String period;
    /**
     * 上午课程（拼接）
     */
    private List<String> morningCourse;
//    private List<String> morningData;
    /**
     * 下午课程（拼接）
     */
    private List<String> afternoonCourse;
//    private List<String> afternoonData;

    public CourseForWeekDTO() {
        this.morningCourse = new ArrayList<>();
        this.afternoonCourse = new ArrayList<>();
    }


//    public CourseForWeekDTO() {
//        this.morningData = new ArrayList<>();
//        this.afternoonData = new ArrayList<>();
//    }
}
