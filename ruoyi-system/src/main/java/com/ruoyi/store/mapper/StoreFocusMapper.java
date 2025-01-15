package com.ruoyi.store.mapper;

import com.ruoyi.store.domain.focus.request.MyFocusRequest;
import com.ruoyi.store.domain.focus.response.StoreFocusResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreFocusMapper {
    List<Long> selectIdsByUserId(MyFocusRequest request);

    List<StoreFocusResponse> getStoresById(@Param("stores") List<Long> stores);
}
