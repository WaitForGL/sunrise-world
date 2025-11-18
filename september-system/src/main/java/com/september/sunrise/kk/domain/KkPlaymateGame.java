package com.september.sunrise.kk.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("kk_playmate_game")
@ApiModel("陪玩游戏配置")
public class KkPlaymateGame {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("陪玩ID")
    private Long playmateId;

    @ApiModelProperty("陪玩名称（冗余字段，方便前台显示）")
    private String playmateName;

    @ApiModelProperty("游戏ID")
    private Long gameId;

    @ApiModelProperty("游戏单名称快照")
    private String gameName;

    @ApiModelProperty("陪玩该游戏单的级别ID")
    private Long levelId;

    @ApiModelProperty("陪玩该游戏单的级别名称")
    private String levelName;

    @ApiModelProperty("陪玩该游戏单价格")
    private BigDecimal price;

    @ApiModelProperty("陪玩该游戏单提成比例")
    private BigDecimal commissionRate;

    @ApiModelProperty("状态 1=启用 0=禁用")
    private Integer status;
}
