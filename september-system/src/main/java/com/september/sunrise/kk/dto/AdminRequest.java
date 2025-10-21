package com.september.sunrise.kk.dto;

import lombok.Data;

/**
 * 管理员新增/编辑请求
 */
@Data
public class AdminRequest {
    private Long id;          // 编辑时需要
    private String username;  // 用户名
    private String password;  // 密码（新增时必填）
    private String nickname;  // 昵称
    private Integer status;   // 状态 1=启用 0=禁用
}

