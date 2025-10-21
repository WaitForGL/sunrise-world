package com.september.sunrise.kk.domain;

import lombok.Data;

/**
 * 用户-角色关联表（kk_user_role）
 */
@Data
public class KkUserRole {
    private Long userId;
    private Long roleId;
}
