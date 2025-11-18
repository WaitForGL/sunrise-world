package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkPlaymateGame;

import java.util.List;

public interface KkPlaymateGameService {

    /**
     * 根据陪玩ID获取该陪玩可接游戏
     */
    List<KkPlaymateGame> listByPlaymate(Long playmateId);

    /**
     * 新增陪玩游戏配置
     */
    void addPlaymateGame(KkPlaymateGame game);

    /**
     * 修改陪玩游戏配置
     */
    void updatePlaymateGame(KkPlaymateGame game);

    /**
     * 删除陪玩游戏配置
     */
    void deletePlaymateGame(Long id);
}
