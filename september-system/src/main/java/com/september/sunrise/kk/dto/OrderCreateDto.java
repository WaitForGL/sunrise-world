package com.september.sunrise.kk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel("前台创建订单DTO")
public class OrderCreateDto {

    @ApiModelProperty("顾客ID")
    @NotNull
    private Long userId;

    @ApiModelProperty("选择游戏单ID")
    @NotNull
    private Long gameId;

    @ApiModelProperty("陪玩ID，可选，不指定时系统按级别派单")
    private Long playmateId;

    @ApiModelProperty("陪玩级别ID，不指定陪玩时必填")
    private Long levelId;

    @ApiModelProperty("时长/局数")
    @NotNull
    private Integer count;

    @ApiModelProperty("备注")
    private String remark;
}
