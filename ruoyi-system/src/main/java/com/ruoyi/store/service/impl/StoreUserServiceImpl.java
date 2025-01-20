package com.ruoyi.store.service.impl;

import com.ruoyi.store.domain.user.StoreUser;
import com.ruoyi.store.mapper.StoreUserMapper;
import com.ruoyi.store.service.IStoreUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StoreUserServiceImpl implements IStoreUserService {
    @Resource
    StoreUserMapper mapper;

    @Override
    public StoreUser selectByOpenid(String openId) {
        StoreUser storeUser = mapper.selectByOpenid(openId);
        return storeUser;
    }

    @Override
    public void insertUserOpenId(String openId) {
        mapper.insertUserOpenId(openId);
    }
}
