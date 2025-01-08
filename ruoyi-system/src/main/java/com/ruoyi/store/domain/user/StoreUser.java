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
}
