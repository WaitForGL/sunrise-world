package com.september.sunrise.kk.domain;

import lombok.Data;

/**
 * 角色-菜单关联表（kk_role_menu）
 */
@Data
public class KkRoleMenu {
    private Long id;
    private String roleCode; // 对应用户 roleCode
    private Long menuId;     // 对应菜单ID
}
