package com.september.store.service.impl;

import com.september.store.domain.user.StoreUser;
import com.september.store.domain.user.request.IndexCountRequest;
import com.september.store.domain.user.response.IndexCountVo;
import com.september.store.mapper.StoreUserMapper;
import com.september.store.service.IStoreUserService;
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
    public void insertUserOpenId(StoreUser storeUser) {
        mapper.insertUserOpenId(storeUser);
    }

    @Override
    public IndexCountVo userIndex(IndexCountRequest request) {
        IndexCountVo indexCountVo = mapper.userIndex(request);
        return indexCountVo;
    }
}
