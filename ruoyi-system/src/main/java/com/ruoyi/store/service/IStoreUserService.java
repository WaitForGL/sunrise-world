package com.ruoyi.store.service;

import com.ruoyi.store.domain.user.StoreUser;
import com.ruoyi.store.domain.user.request.IndexCountRequest;
import com.ruoyi.store.domain.user.response.IndexCountVo;

public interface IStoreUserService {
    //根据openid校验是否新用户
    StoreUser selectByOpenid(String openId);

    void insertUserOpenId(StoreUser storeUser);

    IndexCountVo userIndex(IndexCountRequest request);
}
