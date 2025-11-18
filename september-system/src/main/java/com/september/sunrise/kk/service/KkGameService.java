package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkGame;

import java.util.List;

public interface KkGameService {

    /**
     * 根据分类ID获取启用的游戏单列表
     */
    List<KkGame> listByCategory(Long categoryId);
}
