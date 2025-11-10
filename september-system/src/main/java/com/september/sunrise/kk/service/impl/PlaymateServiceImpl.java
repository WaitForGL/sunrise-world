package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.PlaymateQueryDto;
import com.september.sunrise.kk.mapper.KkUserMapper;
import com.september.sunrise.kk.service.PlaymateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaymateServiceImpl implements PlaymateService {

    @Autowired
    private KkUserMapper kkUserMapper;

    @Override
    public List<KkUser> getPlaymateList(PlaymateQueryDto queryDto) {
        LambdaQueryWrapper<KkUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(KkUser::getRoleCode, "PLAYMATE");
        wrapper.eq(queryDto.getStatus() != null, KkUser::getStatus, queryDto.getStatus());
        wrapper.like(queryDto.getNickname() != null && !queryDto.getNickname().isEmpty(), KkUser::getNickname, queryDto.getNickname());
        wrapper.like(queryDto.getPhone() != null && !queryDto.getPhone().isEmpty(), KkUser::getPhone, queryDto.getPhone());
        wrapper.eq(queryDto.getGender() != null, KkUser::getGender, queryDto.getGender());
        wrapper.ge(queryDto.getStartTime() != null, KkUser::getCreateTime, queryDto.getStartTime());
        wrapper.le(queryDto.getEndTime() != null, KkUser::getCreateTime, queryDto.getEndTime());
        wrapper.eq(KkUser::getIsDelete, 0);
        wrapper.orderByDesc(KkUser::getCreateTime, KkUser::getId);
        return kkUserMapper.selectList(wrapper);
    }

    @Override
    public void addPlaymate(KkUser playmate) {
        playmate.setRoleCode("PLAYMATE");
        playmate.setRoleName("陪玩");
        playmate.setIsDelete(0);
        kkUserMapper.insert(playmate);
    }

    @Override
    public void updatePlaymate(KkUser playmate) {
        kkUserMapper.updateById(playmate);
    }

    @Override
    public void deletePlaymate(Long id) {
        KkUser user = new KkUser();
        user.setId(id);
        user.setIsDelete(1);
        kkUserMapper.updateById(user);
    }

    @Override
    public void leavePlaymate(Long id) {
        KkUser user = new KkUser();
        user.setId(id);
        user.setStatus(2); // 离职
        kkUserMapper.updateById(user);
    }
}
