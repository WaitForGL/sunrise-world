package com.september.store.mapper;

import com.september.store.domain.user.StoreUser;
import com.september.store.domain.user.request.IndexCountRequest;
import com.september.store.domain.user.response.IndexCountVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StoreUserMapper {
    StoreUser selectByOpenid(String openId);

    void insertUserOpenId(StoreUser storeUser);

    IndexCountVo userIndex(IndexCountRequest request);
}
