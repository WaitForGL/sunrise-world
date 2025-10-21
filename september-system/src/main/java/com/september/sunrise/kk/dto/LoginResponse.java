package com.september.sunrise.kk.dto;

import com.september.sunrise.kk.domain.KkMenu;
import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private String token;
    private Long userId;
    private String username;
    private String nickname;
    private List<String> roles; // 角色编码列表
    private List<KkMenu> menus; // 菜单树
}
