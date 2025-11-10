package com.september.sunrise.kk.service.impl;

import com.september.sunrise.kk.domain.KkMenu;
import com.september.sunrise.kk.mapper.KkMenuMapper;
import com.september.sunrise.kk.service.KkMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class KkMenuServiceImpl implements KkMenuService {

    @Resource
    private KkMenuMapper kkMenuMapper;

    @Override
    public List<KkMenu> getMenusByRole(String roleCode) {
        List<KkMenu> menus = kkMenuMapper.selectMenusByRole(roleCode);
        return buildMenuTree(menus, 0L);
    }

    // 构建树形菜单（JDK 1.8 兼容）
    private List<KkMenu> buildMenuTree(List<KkMenu> menus, Long parentId) {
        List<KkMenu> tree = new ArrayList<>();
        for (KkMenu menu : menus) {
            if (menu.getParentId().equals(parentId)) {
                menu.setChildren(buildMenuTree(menus, menu.getId()));
                tree.add(menu);
            }
        }
        return tree;
    }
}
