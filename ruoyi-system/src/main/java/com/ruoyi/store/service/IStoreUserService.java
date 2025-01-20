package com.ruoyi.store.service;

import com.ruoyi.store.domain.user.StoreUser;

public interface IStoreUserService {
    //根据openid校验是否新用户
    StoreUser selectByOpenid(String openId);

    void insertUserOpenId(String openId);
}
