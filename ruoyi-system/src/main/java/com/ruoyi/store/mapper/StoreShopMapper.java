package com.ruoyi.store.mapper;

import com.ruoyi.store.domain.shop.StoreShop;
import com.ruoyi.store.domain.shop.request.HotShopRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreShopMapper {
    List<StoreShop> getAllStores();

    List<StoreShop> isHot(HotShopRequest request);
}
