package com.ruoyi.store.service.impl;

import com.ruoyi.store.domain.index.StoreIndexType;
import com.ruoyi.store.domain.index.vo.StoreIndexTypeVo;
import com.ruoyi.store.mapper.StoreIndexTypeMapper;
import com.ruoyi.store.service.IStoreIndexTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreIndexTypeServiceImpl implements IStoreIndexTypeService {

    @Resource
    private StoreIndexTypeMapper mapper;

    @Override
    public List<StoreIndexTypeVo> list() {
        StoreIndexType storeIndexType = new StoreIndexType();
        storeIndexType.setTypeLevel(0);
        //查询所有一级分类
        List<StoreIndexType> firstType = mapper.listVo(storeIndexType);
        //查询所有一级分类下的二级分类
        List<StoreIndexTypeVo> sonList = new ArrayList<>();
        for(StoreIndexType typeOne : firstType){
            StoreIndexTypeVo sonType = new StoreIndexTypeVo();
            sonType.setIsAllChoosed(false);
            sonType.setIsExpand(false);
            // 复制属性
            try {
                BeanUtils.copyProperties(typeOne, sonType);
            } catch (Exception e) {
                e.printStackTrace();
            }
            storeIndexType.setBelongId(sonType.getId());
            storeIndexType.setTypeLevel(1);
            List<StoreIndexType> secondType = mapper.list(storeIndexType);
            sonType.setList(secondType);
            sonList.add(sonType);
        }
        return sonList;
    }
}
