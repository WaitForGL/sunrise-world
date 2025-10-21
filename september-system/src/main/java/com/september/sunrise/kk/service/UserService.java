package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkUser;

import java.util.List;

public interface UserService {

    /**
     * 查询管理员列表（部分字段 + 派单量）
     */
    List<KkUser> adminList();

    /**
     * 按关键词查询管理员（名称模糊匹配）
     */
    List<KkUser> findAdminsByKeyword(String keyword);

    /**
     * 查询陪玩列表（完整字段）
     */
    List<KkUser> playmateList();

    /**
     * 根据用户名查找用户
     */
    KkUser findByUsername(String username);

    /**
     * 新增管理员
     */
    void addAdmin(KkUser user);

    /**
     * 编辑管理员
     */
    void updateAdmin(KkUser user);

    /**
     * 逻辑删除管理员（标记删除）
     */
    void removeManager(Long id);

    /**
     * 物理删除管理员（彻底删除）
     */
    void deleteManager(Long id);
}
