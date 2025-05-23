package com.september.store.service.impl;

import com.september.store.domain.shop.StoreShop;
import com.september.store.domain.shop.request.HotShopRequest;
import com.september.store.mapper.StoreShopMapper;
import com.september.store.service.IStoreShopService;
import com.september.store.utils.DistanceUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreShopServiceImpl implements IStoreShopService {

    @Resource
    StoreShopMapper mapper;

    /**
     * 热力图查询范围内的店铺列表
     * @param latitude 当前定位的纬度
     * @param longitude 当前定位的经度
     * @param distance 查询的范围大小 km
     * @return 返回店铺列表
     */
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

    /**
     * 店铺查询热门推荐
     * @return
     */
    @Override
    public List<StoreShop> isHot(HotShopRequest request) {
        List<StoreShop> hotList = mapper.isHot(request);
        return hotList;
    }
}
