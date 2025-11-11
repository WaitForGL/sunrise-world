package com.september.sunrise.kk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("充值流水查询DTO")
public class RechargeLogQueryDto {

    @ApiModelProperty(value = "用户ID", example = "1")
    private Long userId;

    @ApiModelProperty(value = "开始时间", example = "2025-11-01 00:00:00")
    private Date startTime;

    @ApiModelProperty(value = "结束时间", example = "2025-11-30 23:59:59")
    private Date endTime;

    @ApiModelProperty(value = "页码", example = "1")
    private Long pageNo = 1L;

    @ApiModelProperty(value = "每页条数", example = "10")
    private Long pageSize = 10L;
}
