package com.september.store.mapper;

import com.september.store.domain.focus.request.MyFocusRequest;
import com.september.store.domain.focus.response.StoreFocusResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreFocusMapper {
    List<Long> selectIdsByUserId(MyFocusRequest request);

    List<StoreFocusResponse> getStoresById(@Param("stores") List<Long> stores);
}
