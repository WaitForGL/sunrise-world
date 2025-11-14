package com.september.sunrise.kk.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("顾客工作台统计结果")
public class CustomerIndexVO {

    @ApiModelProperty("顾客总数量")
    private Long customerCount;

    @ApiModelProperty("充值总金额")
    private BigDecimal totalRechargeAmount;

    @ApiModelProperty("消费总金额（折后总计）")
    private BigDecimal totalConsumeAmount;

    @ApiModelProperty("所有顾客余额汇总")
    private BigDecimal totalBalanceAmount;
}

