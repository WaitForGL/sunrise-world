package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.PlaymateQueryDto;

import java.util.List;

public interface KkPlaymateService {

    /**
     * 获取陪玩列表（分页 + 条件筛选）
     */
    List<KkUser> getPlaymateList(PlaymateQueryDto queryDto);

    /**
     * 新增陪玩
     */
    void addPlaymate(KkUser playmate);

    /**
     * 修改陪玩
     */
    void updatePlaymate(KkUser playmate);

    /**
     * 删除陪玩（逻辑删除）
     */
    void deletePlaymate(Long id);

    /**
     * 陪玩离职（状态=离职，角色保持 PLAYMATE）
     */
    void leavePlaymate(Long id);
}
