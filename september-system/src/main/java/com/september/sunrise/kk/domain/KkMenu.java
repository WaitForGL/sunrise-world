package com.september.sunrise.kk.domain;

import lombok.Data;

import java.util.List;

@Data
public class KkMenu {
    private Long id;
    private String name;
    private String path;
    private String component;
    private String perms;
    private Long parentId;
    private Integer type;
    private Integer orderNum;
    private Integer visible;
    private Integer status;

    // 子菜单
    private List<KkMenu> children;
}
