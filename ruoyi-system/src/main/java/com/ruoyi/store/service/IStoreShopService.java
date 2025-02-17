package com.ruoyi.store.service;

import com.ruoyi.store.domain.shop.StoreShop;

import java.util.List;

public interface IStoreShopService {
    List<StoreShop> StoreListByRange(double latitude, double longitude, double distance);
}
