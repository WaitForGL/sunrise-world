package com.september.store.service;

import com.september.store.domain.user.StoreUser;
import com.september.store.domain.user.request.IndexCountRequest;
import com.september.store.domain.user.response.IndexCountVo;

public interface IStoreUserService {
    //根据openid校验是否新用户
    StoreUser selectByOpenid(String openId);

    void insertUserOpenId(StoreUser storeUser);

    IndexCountVo userIndex(IndexCountRequest request);
}
