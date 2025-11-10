package com.september.sunrise.kk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 客服列表查询条件
 */
@Data
@ApiModel(value = "ManagerQueryDto", description = "客服列表查询条件")
public class ManagerQueryDto {

    @ApiModelProperty(value = "页码", required = true, example = "1")
    private Integer pageNo = 1;

    @ApiModelProperty(value = "每页条数", required = true, example = "10")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "状态：0禁用 1启用 2离职", example = "1")
    private Integer status;

    @ApiModelProperty(value = "昵称模糊搜索", example = "张三")
    private String nickname;

    @ApiModelProperty(value = "手机号模糊搜索", example = "13800000000")
    private String phone;

    @ApiModelProperty(value = "入职开始时间", example = "2025-01-01")
    private Date startTime;

    @ApiModelProperty(value = "入职结束时间", example = "2025-12-31")
    private Date endTime;
}
