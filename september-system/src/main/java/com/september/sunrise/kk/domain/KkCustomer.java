package com.september.sunrise.kk.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 顾客表（客户名单）
 */
@Data
public class KkCustomer {

    private Long id;                  // 顾客ID（主键，可自增）

    private Date registerTime;        // 注册时间
    private Long bossId;              // 老板编号
    private String bossNickname;      // 老板昵称

    private Integer gender;           // 性别 1男 2女
    private String wechat;            // 联系微信
    private String phone;             // 联系手机

    private Integer cardCount;        // 卡数量
    private BigDecimal totalRecharge; // 累计充值
    private BigDecimal totalGift;     // 累计赠送
    private BigDecimal totalConsume;  // 累计消费
    private BigDecimal totalLock;     // 累计锁定
    private BigDecimal remainingBalance; // 剩余余额

    private String referrer;          // 推荐人
    private BigDecimal referrerCommission; // 推荐人抽成
    private String remark;            // 备注
    private String operator;          // 操作人
}
