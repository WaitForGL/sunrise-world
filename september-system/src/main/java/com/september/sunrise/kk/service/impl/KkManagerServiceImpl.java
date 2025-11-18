package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.ManagerQueryDto;
import com.september.sunrise.kk.mapper.KkUserMapper;
import com.september.sunrise.kk.service.KkManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KkManagerServiceImpl implements KkManagerService {

    @Autowired
    private KkUserMapper kkUserMapper;

    @Override
    public List<KkUser> getManagerList(ManagerQueryDto queryDto) {
        LambdaQueryWrapper<KkUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(KkUser::getRoleCode, "MANAGER"); // 只查询客服
        wrapper.eq(queryDto.getStatus() != null, KkUser::getStatus, queryDto.getStatus());
        wrapper.like(queryDto.getNickname() != null && !queryDto.getNickname().isEmpty(), KkUser::getNickname, queryDto.getNickname());
        wrapper.like(queryDto.getPhone() != null && !queryDto.getPhone().isEmpty(), KkUser::getPhone, queryDto.getPhone());
        wrapper.ge(queryDto.getStartTime() != null, KkUser::getCreateTime, queryDto.getStartTime());
        wrapper.le(queryDto.getEndTime() != null, KkUser::getCreateTime, queryDto.getEndTime());
        wrapper.eq(KkUser::getIsDelete, 0); // 排除逻辑删除
        wrapper.orderByDesc(KkUser::getCreateTime, KkUser::getId);
        return kkUserMapper.selectList(wrapper);
    }

    @Override
    public void addManager(KkUser user) {
        user.setRoleCode("MANAGER");
        user.setRoleName("客服");
        user.setIsDelete(0);
        kkUserMapper.insert(user);
    }

    @Override
    public void deleteManager(Long id) {
        KkUser user = new KkUser();
        user.setId(id);
        user.setIsDelete(1); // 逻辑删除
        kkUserMapper.updateById(user);
    }

    @Override
    public void leaveManager(Long id) {
        KkUser user = new KkUser();
        user.setId(id);
        user.setRoleCode("CUSTOMERS"); // 离职后修改为普通顾客
        user.setRoleName("顾客");
        user.setStatus(2); // 状态改为离职
        kkUserMapper.updateById(user);
    }
}
