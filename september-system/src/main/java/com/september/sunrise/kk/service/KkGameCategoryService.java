package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkGameCategory;

import java.util.List;

public interface KkGameCategoryService {

    /**
     * 获取所有启用的游戏分类
     */
    List<KkGameCategory> listEnabledCategories();
}
