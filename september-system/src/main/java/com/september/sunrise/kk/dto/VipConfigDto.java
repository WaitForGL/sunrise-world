package com.september.sunrise.kk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("VIP等级配置DTO")
public class VipConfigDto {

    @ApiModelProperty(value = "VIP等级", required = true, example = "1")
    private Integer vipLevel;

    @ApiModelProperty(value = "VIP名称", required = true, example = "VIP1 普通会员")
    private String vipName;

    @ApiModelProperty(value = "达到该等级所需累计充值金额", required = true, example = "1000.00")
    private BigDecimal rechargeThreshold;

    @ApiModelProperty(value = "备注", example = "备注说明")
    private String remark;
}
