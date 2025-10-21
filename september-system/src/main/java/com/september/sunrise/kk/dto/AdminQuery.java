package com.september.sunrise.kk.dto;

import lombok.Data;

/**
 * 管理员查询条件
 */
@Data
public class AdminQuery {
    private String keyword; // 名称/昵称模糊查询
}
