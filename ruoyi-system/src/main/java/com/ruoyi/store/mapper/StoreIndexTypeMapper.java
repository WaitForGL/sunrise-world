package com.ruoyi.store.mapper;

import com.ruoyi.store.domain.index.StoreIndexType;
import com.ruoyi.store.domain.index.vo.StoreIndexTypeVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreIndexTypeMapper {
    List<StoreIndexType> listVo(StoreIndexType storeIndexType);
    List<StoreIndexType> list(StoreIndexType storeIndexType);
}
