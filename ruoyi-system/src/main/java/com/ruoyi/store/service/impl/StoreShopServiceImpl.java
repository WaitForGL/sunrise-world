package com.ruoyi.store.service.impl;

import com.ruoyi.store.mapper.StoreShopMapper;
import com.ruoyi.store.mapper.StoreUserMapper;
import com.ruoyi.store.service.IStoreShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StoreShopServiceImpl implements IStoreShopService {

    @Resource
    StoreShopMapper mapper;
}
