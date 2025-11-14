package com.september.sunrise.kk.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("VIP等级配置")
public class KkVipConfig {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("VIP等级")
    private Integer vipLevel;

    @ApiModelProperty("VIP名称，如VIP1 普通会员、VIP2 白银会员")
    private String vipName;

    @ApiModelProperty("所需累计充值金额")
    private BigDecimal rechargeThreshold;

    @ApiModelProperty("说明")
    private String remark;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;
}
