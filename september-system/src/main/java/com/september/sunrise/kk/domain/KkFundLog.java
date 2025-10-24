package com.september.sunrise.kk.domain;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资金流水日志表
 */
@Data
public class KkFundLog {

    private Long id;                  // 主键ID
    private Long refId;               // 关联业务ID
    private String refType;           // 业务类型
    private Long userId;              // 用户ID
    private String userRole;          // 用户角色（CUSTOMER / PLAYMATE）
    private String flowType;          // 流水类型（INCOME / EXPENSE）
    private BigDecimal amount;        // 金额
    private BigDecimal balanceAfter;  // 变动后余额
    private String remark;            // 备注
    private Date createTime;          // 创建时间
}
