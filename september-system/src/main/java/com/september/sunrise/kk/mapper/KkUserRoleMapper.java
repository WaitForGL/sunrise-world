package com.september.sunrise.kk.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KkUserRoleMapper {

    /**
     * 根据用户ID查询角色ID列表
     */
    List<Long> findRoleIdsByUserId(@Param("userId") Long userId);

    /**
     * 根据角色ID查询用户ID列表（可选备用）
     */
    List<Long> findUserIdsByRoleId(@Param("roleId") Long roleId);
}