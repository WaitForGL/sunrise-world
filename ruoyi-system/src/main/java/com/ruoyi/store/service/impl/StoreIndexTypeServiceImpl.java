package com.ruoyi.store.service.impl;

import com.ruoyi.store.mapper.StoreIndexTypeMapper;
import com.ruoyi.store.service.IStoreIndexTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StoreIndexTypeServiceImpl implements IStoreIndexTypeService {

    @Resource
    private StoreIndexTypeMapper mapper;
}
