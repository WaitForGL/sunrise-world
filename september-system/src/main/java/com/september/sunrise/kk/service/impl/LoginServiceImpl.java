package com.september.sunrise.kk.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.september.sunrise.kk.domain.KkMenu;
import com.september.sunrise.kk.domain.KkRole;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.LoginRequest;
import com.september.sunrise.kk.dto.LoginResponse;
import com.september.sunrise.kk.mapper.KkMenuMapper;
import com.september.sunrise.kk.mapper.KkRoleMapper;
import com.september.sunrise.kk.mapper.KkUserMapper;
import com.september.sunrise.kk.service.LoginService;
import com.september.common.utils.JAssert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private KkUserMapper userMapper;

    @Resource
    private KkRoleMapper roleMapper;

    @Resource
    private KkMenuMapper menuMapper;

    @Override
    public LoginResponse login(LoginRequest request) {
        JAssert.notNull(request, "请求不能为空");
        JAssert.isTrue(request.getUsername() != null && !request.getUsername().trim().isEmpty(), "用户名不能为空");
        JAssert.isTrue(request.getPassword() != null && !request.getPassword().trim().isEmpty(), "密码不能为空");

        KkUser user = userMapper.findByUsername(request.getUsername());
        JAssert.notNull(user, "用户不存在");

        String md5Password = DigestUtil.md5Hex(request.getPassword());
        JAssert.isTrue(md5Password.equals(user.getPassword()), "密码错误");
        JAssert.isTrue(user.getStatus() == 1, "账户已被禁用");

        // 查询角色
        List<KkRole> roles = roleMapper.findByUserId(user.getId());
        List<String> roleCodes = new ArrayList<>();
        for (KkRole role : roles) {
            roleCodes.add(role.getRoleCode());
        }

        // 查询菜单
        List<KkMenu> menus;
        switch (user.getRoleCode()) {
            case "PLAYMATE":
                menus = menuMapper.findMenusByRoleCode("PLAYMATE");
                break;
            case "ADMIN":
            case "BOSS":
                menus = menuMapper.findAllMenus();
                break;
            default:
                menus = menuMapper.findMenusByRoleCode(user.getRoleCode()); // 可扩展
                break;
        }
        menus = buildMenuTree(menus);

        // 构建返回对象
        LoginResponse resp = new LoginResponse();
        resp.setToken(IdUtil.fastSimpleUUID());
        resp.setUserId(user.getId());
        resp.setUsername(user.getUsername());
        resp.setNickname(user.getNickname());
        resp.setRoles(roleCodes);
        resp.setMenus(menus);

        return resp;
    }

    /**
     * 构建菜单树
     */
    private List<KkMenu> buildMenuTree(List<KkMenu> menus) {
        Map<Long, KkMenu> map = new HashMap<>();
        for (KkMenu m : menus) {
            map.put(m.getId(), m);
        }

        List<KkMenu> roots = new ArrayList<>();
        for (KkMenu m : menus) {
            if (m.getParentId() == 0) {
                roots.add(m);
            } else {
                KkMenu parent = map.get(m.getParentId());
                if (parent != null) {
                    if (parent.getChildren() == null) {
                        parent.setChildren(new ArrayList<KkMenu>());
                    }
                    parent.getChildren().add(m);
                }
            }
        }
        return roots;
    }
}
