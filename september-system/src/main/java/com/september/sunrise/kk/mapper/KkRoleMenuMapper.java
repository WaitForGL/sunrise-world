package com.september.sunrise.kk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KkRoleMenuMapper {

    /**
     * 根据角色ID查询菜单ID列表
     */
    List<Long> findMenuIdsByRoleId(@Param("roleId") Long roleId);

}