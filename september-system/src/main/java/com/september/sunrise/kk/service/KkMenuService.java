package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkMenu;

import java.util.List;

public interface KkMenuService {
    List<KkMenu> getMenusByRole(String roleCode);
}
