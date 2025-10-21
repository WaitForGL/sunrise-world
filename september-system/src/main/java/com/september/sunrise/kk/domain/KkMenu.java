package com.september.sunrise.kk.domain;

import lombok.Data;
import java.util.List;

/**
 * 菜单表（kk_menu）
 */
@Data
public class KkMenu {
    private Long id;
    private String menuName;
    private String menuCode;
    private String path;
    private String icon;
    private Long parentId;
    private Integer sort;
    private Integer status;              // 1=启用 0=禁用

    // 非数据库字段
    private List<KkMenu> children;
}
