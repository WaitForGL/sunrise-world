package com.ruoyi.store.domain.user;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class StoreUser extends BaseEntity {

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
