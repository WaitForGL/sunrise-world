package com.september.sunrise.kk.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("kk_order")
@ApiModel("订单")
public class KkOrder {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("订单ID")
    private Long id;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("订单日期")
    private LocalDateTime orderTime;

    @ApiModelProperty("处理客服ID")
    private Long managerId;

    @ApiModelProperty("处理客服名称")
    private String managerName;

    @ApiModelProperty("顾客ID")
    private Long customerId;

    @ApiModelProperty("顾客名称")
    private String customerName;

    @ApiModelProperty("陪玩ID")
    private Long playmateId;

    @ApiModelProperty("陪玩名称")
    private String playmateName;

    @ApiModelProperty("陪玩级别ID")
    private Long playmateLevelId;

    @ApiModelProperty("陪玩级别名称")
    private String playmateLevelName;

    @ApiModelProperty("游戏ID")
    private Long gameId;

    @ApiModelProperty("游戏名称快照")
    private String gameName;

    @ApiModelProperty("单价")
    private BigDecimal unitPrice;

    @ApiModelProperty("数量/局数/时长")
    private Integer count;

    @ApiModelProperty("陪玩提成比例")
    private BigDecimal commissionRate;

    @ApiModelProperty("老板折扣比例")
    private BigDecimal discountRate;

    @ApiModelProperty("订单总计")
    private BigDecimal totalAmount;

    @ApiModelProperty("折后总计")
    private BigDecimal discountedAmount;

    @ApiModelProperty("陪玩收入")
    private BigDecimal playmateIncome;

    @ApiModelProperty("店内收入")
    private BigDecimal storeIncome;

    @ApiModelProperty("订单状态 0=待支付 1=进行中 2=已完成 3=已取消")
    private Integer status;

    @ApiModelProperty("订单截图")
    private String screenshot;

    @ApiModelProperty("附件")
    private String attachment;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("逻辑删除 0=否 1=是")
    private Integer isDelete;
}
