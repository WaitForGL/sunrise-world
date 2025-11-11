package com.september.sunrise.kk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("充值请求DTO")
public class RechargeDto {

    @ApiModelProperty(value = "用户ID", required = true, example = "1")
    private Long userId;

    @ApiModelProperty(value = "充值金额", required = true, example = "1000.00")
    private BigDecimal amount;

    @ApiModelProperty(value = "备注", example = "充值说明")
    private String remark;
}
