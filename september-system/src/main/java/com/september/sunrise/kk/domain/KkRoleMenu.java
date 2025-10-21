package com.september.sunrise.kk.domain;

import lombok.Data;

/**
 * 角色-菜单关联表（kk_role_menu）
 */
@Data
public class KkRoleMenu {
    private Long roleId;
    private Long menuId;
}
