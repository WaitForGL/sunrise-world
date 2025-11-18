package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.september.sunrise.kk.domain.KkGameCategory;
import com.september.sunrise.kk.mapper.KkGameCategoryMapper;
import com.september.sunrise.kk.service.KkGameCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KkGameCategoryServiceImpl implements KkGameCategoryService {

    private final KkGameCategoryMapper categoryMapper;

    @Override
    public List<KkGameCategory> listEnabledCategories() {
        LambdaQueryWrapper<KkGameCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(KkGameCategory::getStatus, 1)
                .orderByAsc(KkGameCategory::getSort);
        return categoryMapper.selectList(wrapper);
    }
}
