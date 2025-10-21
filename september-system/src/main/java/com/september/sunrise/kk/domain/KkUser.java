package com.september.sunrise.kk.domain;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 用户表（kk_user）
 */
@Data
public class KkUser {
    private Long id;                  // 用户ID / 陪玩ID

    private String username;          // 登录用户名
    private String password;          // 登录密码（MD5或加密）
    private String nickname;          // 昵称

    private String roleCode;          // 角色类型 ADMIN/BOSS/PLAYMATE
    private String roleName;          // 角色名称（用于展示）

    private Integer status;           // 状态 1=启用 0=禁用 2=离职
    private Date createTime;          // 创建/入职时间
    private Date updateTime;          // 更新时间

    // 逻辑删除字段
    private Integer isDelete;         // 是否删除 0否 1是

    // 陪玩专属字段
    private Integer gender;           // 性别 1男 2女
    private String wechat;            // 微信号
    private String phone;             // 手机号
    private String alipayAccount;     // 支付宝账号
    private String alipayName;        // 支付宝实名
    private BigDecimal commissionRate; // 陪玩提成比例
    private BigDecimal totalIncome;    // 累计收入
    private BigDecimal withdrawnAmount;// 成功提现
    private BigDecimal remainingAmount;// 剩余可提现（totalIncome - withdrawnAmount）
    private Integer withdrawLock;      // 提现锁定 0否 1是
    private String intro;              // 自我介绍
    private String avatar;             // 头像/照片
    private String remark;             // 备注

    // 管理员列表字段
    private Integer dispatchCount;     // 派单量（关联 kk_order 统计）
}