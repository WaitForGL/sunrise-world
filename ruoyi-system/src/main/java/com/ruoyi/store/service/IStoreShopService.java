package com.ruoyi.store.service;

import com.ruoyi.store.domain.shop.StoreShop;
import com.ruoyi.store.domain.shop.request.HotShopRequest;

import java.util.List;

public interface IStoreShopService {
    List<StoreShop> StoreListByRange(double latitude, double longitude, double distance);

    List<StoreShop> isHot(HotShopRequest request);
}
