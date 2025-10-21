package com.september.sunrise.kk.mapper;

import com.september.sunrise.kk.domain.KkMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KkMenuMapper {

    /**
     * 根据角色查询菜单（陪玩可见）
     */
    List<KkMenu> findMenusByRoleCode(@Param("roleCode") String roleCode);

    /**
     * 查询全部菜单（管理员/老板可见）
     */
    List<KkMenu> findAllMenus();
}