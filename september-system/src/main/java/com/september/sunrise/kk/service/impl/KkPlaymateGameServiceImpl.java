package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.september.sunrise.kk.domain.KkPlaymateGame;
import com.september.sunrise.kk.mapper.KkPlaymateGameMapper;
import com.september.sunrise.kk.service.KkPlaymateGameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KkPlaymateGameServiceImpl implements KkPlaymateGameService {

    @Resource
    private KkPlaymateGameMapper playmateGameMapper;

    @Override
    public List<KkPlaymateGame> listByPlaymate(Long playmateId) {
        LambdaQueryWrapper<KkPlaymateGame> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(KkPlaymateGame::getPlaymateId, playmateId)
                .eq(KkPlaymateGame::getStatus, 1)
                .orderByAsc(KkPlaymateGame::getId);
        return playmateGameMapper.selectList(wrapper);
    }

    @Override
    public void addPlaymateGame(KkPlaymateGame game) {
        playmateGameMapper.insert(game);
    }

    @Override
    public void updatePlaymateGame(KkPlaymateGame game) {
        playmateGameMapper.updateById(game);
    }

    @Override
    public void deletePlaymateGame(Long id) {
        playmateGameMapper.deleteById(id);
    }
}
