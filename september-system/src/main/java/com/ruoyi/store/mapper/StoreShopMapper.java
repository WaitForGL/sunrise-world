package com.september.store.mapper;

import com.september.store.domain.shop.StoreShop;
import com.september.store.domain.shop.request.HotShopRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreShopMapper {
    List<StoreShop> getAllStores();

    List<StoreShop> isHot(HotShopRequest request);
}
