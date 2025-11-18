package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.september.sunrise.kk.domain.KkGame;
import com.september.sunrise.kk.mapper.KkGameMapper;
import com.september.sunrise.kk.service.KkGameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KkGameServiceImpl implements KkGameService {

    @Resource
    private KkGameMapper gameMapper;

    @Override
    public List<KkGame> listByCategory(Long categoryId) {
        LambdaQueryWrapper<KkGame> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(KkGame::getCategoryId, categoryId)
                .eq(KkGame::getStatus, 1)
                .orderByAsc(KkGame::getId);
        return gameMapper.selectList(wrapper);
    }
}
