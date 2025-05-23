package com.september.store.domain.user;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StoreUser{

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 用户余额
     */
    private BigDecimal balance;

    /**
     * 可提现金额
     */
    private BigDecimal allowBalance;

    /**
     * 已提现金额
     */
    private BigDecimal alreadyBalance;

    /**
     * 用户标识（0:合伙人 1:vip 2:普通用户）
     */
    private Integer userType;

    /**
     * 微信唯一标识open_id
     */
    private String openId;

    /**
     * 用户状态（0:正常 1:停用）
     */
    private Integer status;
}
