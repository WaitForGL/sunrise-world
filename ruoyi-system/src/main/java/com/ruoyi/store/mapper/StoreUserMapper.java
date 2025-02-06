package com.ruoyi.store.mapper;

import com.ruoyi.store.domain.user.StoreUser;
import com.ruoyi.store.domain.user.request.IndexCountRequest;
import com.ruoyi.store.domain.user.response.IndexCountVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreUserMapper {
    StoreUser selectByOpenid(String openId);

    void insertUserOpenId(StoreUser storeUser);

    IndexCountVo userIndex(IndexCountRequest request);
}
