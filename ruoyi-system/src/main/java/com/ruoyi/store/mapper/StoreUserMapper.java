package com.ruoyi.store.mapper;

import com.ruoyi.store.domain.user.StoreUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreUserMapper {
    StoreUser selectByOpenid(String openId);

    void insertUserOpenId(String openId);
}
