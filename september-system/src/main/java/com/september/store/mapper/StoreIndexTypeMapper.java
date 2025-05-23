package com.september.store.mapper;

import com.september.store.domain.index.StoreIndexType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreIndexTypeMapper {
    List<StoreIndexType> listVo(StoreIndexType storeIndexType);
    List<StoreIndexType> list(StoreIndexType storeIndexType);
}
