package com.september.sunrise.kk.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表（kk_order）
 */
@Data
@ApiModel(value = "KkOrder", description = "订单实体")
public class KkOrder {

    @ApiModelProperty("订单ID")
    private Long id;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("订单日期")
    private Date orderDate;

    @ApiModelProperty("处理客服ID")
    private Long managerId;

    @ApiModelProperty("处理客服昵称")
    private String managerName;

    @ApiModelProperty("顾客ID")
    private Long customerId;

    @ApiModelProperty("顾客昵称")
    private String customerName;

    @ApiModelProperty("陪玩ID")
    private Long playmateId;

    @ApiModelProperty("陪玩昵称")
    private String playmateName;

    @ApiModelProperty("游戏品类")
    private String gameCategory;

    @ApiModelProperty("单价（每小时或每局）")
    private BigDecimal unitPrice;

    @ApiModelProperty("时长/局数")
    private Integer quantity;

    @ApiModelProperty("陪玩提成比例（百分比）")
    private BigDecimal commissionRate;

    @ApiModelProperty("折扣比例（老板折扣）")
    private BigDecimal discountRate;

    @ApiModelProperty("订单总计（unitPrice * quantity）")
    private BigDecimal totalAmount;

    @ApiModelProperty("折后总计（totalAmount * discountRate）")
    private BigDecimal discountedAmount;

    @ApiModelProperty("陪玩收入（discountedAmount * commissionRate）")
    private BigDecimal playmateIncome;

    @ApiModelProperty("店内收入（discountedAmount - playmateIncome）")
    private BigDecimal storeIncome;

    @ApiModelProperty("订单状态（0待处理 1已完成 2已取消）")
    private Integer status;

    @ApiModelProperty("订单截图URL")
    private String screenshot;

    @ApiModelProperty("附件路径")
    private String attachment;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("逻辑删除 0=否 1=是")
    private Integer isDelete;
}
