package com.ruoyi.store.service.impl;

import com.ruoyi.store.domain.shop.StoreShop;
import com.ruoyi.store.mapper.StoreShopMapper;
import com.ruoyi.store.mapper.StoreUserMapper;
import com.ruoyi.store.service.IStoreShopService;
import com.ruoyi.store.utils.DistanceUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreShopServiceImpl implements IStoreShopService {

    @Resource
    StoreShopMapper mapper;

    @Override
    public List<StoreShop> StoreListByRange(double latitude, double longitude, double distance) {

        List<StoreShop> allStores = mapper.getAllStores();  // 获取所有店铺
        // 使用流处理筛选出距离小于等于1公里的店铺
        return allStores.stream()
                .filter(store -> {
                    // 使用 Haversine 公式计算用户与店铺之间的距离
                    double betweenDistance = DistanceUtils.calculateDistance(latitude, longitude, store.getShopLat(), store.getShopLon());
                    return betweenDistance <= distance;  // 距离范围以内的店铺
                })
                .collect(Collectors.toList());  // 返回符合条件的店铺列表
    }
}
