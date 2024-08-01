package com.september.sunrise.entity.demo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DemoStudentResponse implements Serializable {

    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "班级id")
    private Integer classId;

    @ApiModelProperty(value = "学生姓名")
    private String stuName;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "是否删除 0 未删除 1 已删除")
    private Integer isDelete;

}
