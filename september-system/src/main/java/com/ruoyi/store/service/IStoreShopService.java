package com.september.store.service;

import com.september.store.domain.shop.StoreShop;
import com.september.store.domain.shop.request.HotShopRequest;

import java.util.List;

public interface IStoreShopService {
    List<StoreShop> StoreListByRange(double latitude, double longitude, double distance);

    List<StoreShop> isHot(HotShopRequest request);
}
