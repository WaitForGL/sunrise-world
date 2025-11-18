package com.september.sunrise.kk.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("kk_playmate_level")
@ApiModel("陪玩级别")
public class KkPlaymateLevel {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("级别名称")
    private String name;

    @ApiModelProperty("状态 1=启用 0=禁用")
    private Integer status;
}
