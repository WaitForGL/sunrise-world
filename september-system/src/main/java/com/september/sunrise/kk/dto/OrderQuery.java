package com.september.sunrise.kk.dto;

import lombok.Data;

import java.util.Date;

/**
 * 订单查询条件
 */
@Data
public class OrderQuery {
    private String playmateName;     // 陪玩昵称
    private String bossAccount;      // 老板账号
    private Integer orderStatus;     // 订单状态
    private Date startTime;          // 开始时间
    private Date endTime;            // 结束时间
}
