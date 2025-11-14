package com.september.sunrise.kk.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户表（kk_user）
 */
@Data
@ApiModel(value = "KkUser", description = "用户信息实体类（包括管理员、老板、客服、陪玩、顾客）")
public class KkUser {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "用户ID / 陪玩ID", example = "1")
    private Long id;

    @ApiModelProperty(value = "登录用户名", example = "admin")
    private String username;

    @ApiModelProperty(value = "登录密码（明文存储）", example = "123456")
    private String password;

    @ApiModelProperty(value = "昵称", example = "管理员A")
    private String nickname;

    @ApiModelProperty(value = "角色类型（ADMIN/BOSS/MANAGER/PLAYMATE/CUSTOMERS）", example = "MANAGER")
    private String roleCode;

    @ApiModelProperty(value = "角色名称（管理员/老板/客服/陪玩/顾客）", example = "客服")
    private String roleName;

    @ApiModelProperty(value = "状态：1=启用 0=禁用 2=离职", example = "1")
    private Integer status;

    @ApiModelProperty(value = "创建/入职时间", example = "2025-11-10 12:00:00")
    private Date createTime;

    @ApiModelProperty(value = "更新时间", example = "2025-11-10 12:30:00")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除：0=否 1=是", example = "0")
    private Integer isDelete;

    @ApiModelProperty(value = "性别：1=男 2=女", example = "1")
    private Integer gender;

    @ApiModelProperty(value = "微信号", example = "wx123456")
    private String wechat;

    @ApiModelProperty(value = "手机号", example = "13800000000")
    private String phone;

    @ApiModelProperty(value = "支付宝账号", example = "alipay@demo.com")
    private String alipayAccount;

    @ApiModelProperty(value = "支付宝实名", example = "张三")
    private String alipayName;

    @ApiModelProperty(value = "陪玩提成比例", example = "0.30")
    private BigDecimal commissionRate;

    @ApiModelProperty(value = "累计收入", example = "5000.00")
    private BigDecimal totalIncome;

    @ApiModelProperty(value = "成功提现金额", example = "3000.00")
    private BigDecimal withdrawnAmount;

    @ApiModelProperty(value = "剩余可提现金额", example = "2000.00")
    private BigDecimal remainingAmount;

    @ApiModelProperty(value = "提现锁定：0=否 1=是", example = "0")
    private Integer withdrawLock;

    @ApiModelProperty(value = "自我介绍", example = "你好，我是专业陪玩~")
    private String intro;

    @ApiModelProperty(value = "头像/照片", example = "https://cdn.xxx.com/avatar.jpg")
    private String avatar;

    @ApiModelProperty(value = "备注", example = "优秀员工")
    private String remark;

    @ApiModelProperty(value = "派单量（关联 kk_order 统计）", example = "35")
    private Integer dispatchCount;

    @ApiModelProperty("VIP等级")
    private Integer vipLevel;

    @ApiModelProperty("VIP名称")
    private String vipName;

    @ApiModelProperty("累计充值金额")
    private BigDecimal totalRecharge;
}
