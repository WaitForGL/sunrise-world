package com.september.sunrise.kk.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("kk_game")
@ApiModel("游戏单")
public class KkGame {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("分类ID")
    private Long categoryId;

    @ApiModelProperty("游戏单名称")
    private String name;

    @ApiModelProperty("定价（非陪玩单）")
    private BigDecimal price;

    @ApiModelProperty("状态 1=启用 0=禁用")
    private Integer status;
}
