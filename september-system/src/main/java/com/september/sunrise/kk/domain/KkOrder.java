package com.september.sunrise.kk.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 */
@Data
public class KkOrder {

    private Long id;                  // 主键ID
    private String orderNo;           // 订单编号
    private Date orderTime;           // 订单时间

    private Long customerServiceId;   // 客服ID
    private String bossAccount;       // 老板账户
    private String playmateName;      // 陪玩名称
    private String category;          // 品类

    private BigDecimal unitPrice;     // 单价
    private Integer quantity;         // 时长/局数
    private BigDecimal commissionRate; // 陪玩提成比例
    private BigDecimal discountRate;   // 折扣比例
    private BigDecimal totalAfterDiscount; // 折后总计
    private BigDecimal orderTotal;        // 订单总计
    private BigDecimal storeIncome;       // 店内收入
    private BigDecimal playmateIncome;    // 陪玩收入

    private Integer orderStatus;       // 订单状态 1=待完成 2=已完成 3=已取消
    private Integer reportConfirmStatus; // 报单确认状态 0=未确认 1=已确认

    private String remark;             // 备注
    private Date createTime;           // 创建时间
    private Date updateTime;           // 更新时间
    // 逻辑删除字段
    private Integer isDelete;         // 是否删除 0否 1是
}
