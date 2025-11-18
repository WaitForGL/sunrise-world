package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.CustomerQueryDto;
import com.september.sunrise.kk.mapper.KkUserMapper;
import com.september.sunrise.kk.service.KkCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KkCustomerServiceImpl implements KkCustomerService {

    @Autowired
    private KkUserMapper kkUserMapper;

    @Override
    public List<KkUser> getCustomerList(CustomerQueryDto queryDto) {
        LambdaQueryWrapper<KkUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(KkUser::getRoleCode, "CUSTOMERS");
        wrapper.eq(queryDto.getStatus() != null, KkUser::getStatus, queryDto.getStatus());
        wrapper.like(queryDto.getNickname() != null && !queryDto.getNickname().isEmpty(), KkUser::getNickname, queryDto.getNickname());
        wrapper.like(queryDto.getPhone() != null && !queryDto.getPhone().isEmpty(), KkUser::getPhone, queryDto.getPhone());
        wrapper.ge(queryDto.getStartTime() != null, KkUser::getCreateTime, queryDto.getStartTime());
        wrapper.le(queryDto.getEndTime() != null, KkUser::getCreateTime, queryDto.getEndTime());
        wrapper.eq(KkUser::getIsDelete, 0); // 逻辑删除
        wrapper.orderByDesc(KkUser::getCreateTime, KkUser::getId);
        return kkUserMapper.selectList(wrapper);
    }

    @Override
    public void addCustomer(KkUser user) {
        user.setRoleCode("CUSTOMERS");
        user.setRoleName("顾客");
        user.setIsDelete(0);
        kkUserMapper.insert(user);
    }

    @Override
    public void updateCustomer(KkUser user) {
        kkUserMapper.updateById(user);
    }

    @Override
    public void deleteCustomer(Long id) {
        KkUser user = new KkUser();
        user.setId(id);
        user.setIsDelete(1);
        kkUserMapper.updateById(user);
    }
}
