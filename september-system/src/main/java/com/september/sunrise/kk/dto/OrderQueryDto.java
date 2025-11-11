package com.september.sunrise.kk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "OrderQueryDto", description = "订单查询条件")
public class OrderQueryDto {

    @ApiModelProperty(value = "页码", example = "1")
    private Integer pageNo = 1;

    @ApiModelProperty(value = "每页条数", example = "10")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "订单状态 0待处理 1已完成 2已取消")
    private Integer status;

    @ApiModelProperty(value = "顾客昵称")
    private String customerName;

    @ApiModelProperty(value = "陪玩昵称")
    private String playmateName;

    @ApiModelProperty(value = "客服昵称")
    private String managerName;

    @ApiModelProperty(value = "游戏品类")
    private String gameCategory;

    @ApiModelProperty(value = "订单日期起")
    private Date startDate;

    @ApiModelProperty(value = "订单日期止")
    private Date endDate;
}
