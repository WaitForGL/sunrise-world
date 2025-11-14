package com.september.sunrise.kk.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("充值记录")
public class KkRechargeLog {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("充值金额")
    private BigDecimal amount;

    @ApiModelProperty("充值前累计金额")
    private BigDecimal beforeAmount;

    @ApiModelProperty("充值后累计金额")
    private BigDecimal afterAmount;

    @ApiModelProperty("充值前VIP等级")
    private Integer vipBefore;

    @ApiModelProperty("充值后VIP等级")
    private Integer vipAfter;

    @ApiModelProperty("充值时间")
    private Date createTime;

    @ApiModelProperty("备注")
    private String remark;
}
