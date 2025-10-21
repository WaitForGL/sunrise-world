package com.september.sunrise.kk.domain;

import lombok.Data;

/**
 * 角色表（kk_role）
 */
@Data
public class KkRole {
    private Long id;
    private String roleName;
    private String roleCode;
    private String remark;
}