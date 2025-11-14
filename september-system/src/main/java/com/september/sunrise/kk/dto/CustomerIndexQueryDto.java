package com.september.sunrise.kk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("顾客工作台统计筛选条件")
public class CustomerIndexQueryDto {

    @ApiModelProperty("开始日期 (yyyy-MM-dd)")
    private String startDate;

    @ApiModelProperty("结束日期 (yyyy-MM-dd)")
    private String endDate;

    @ApiModelProperty("充值状态（0：未充值，1：已充值）")
    private Integer rechargeStatus;

    @ApiModelProperty("订单状态（0未完成，1已完成，2取消等）")
    private Integer orderStatus;
}

