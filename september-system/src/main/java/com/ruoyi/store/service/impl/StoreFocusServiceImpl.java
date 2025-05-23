package com.september.store.service.impl;

import com.september.store.domain.focus.request.MyFocusRequest;
import com.september.store.domain.focus.response.StoreFocusResponse;
import com.september.store.mapper.StoreFocusMapper;
import com.september.store.service.IStoreFocusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class StoreFocusServiceImpl implements IStoreFocusService {

    @Resource
    private StoreFocusMapper mapper;


    @Override
    public List<StoreFocusResponse> myFocus(MyFocusRequest request) {
        //1 获取用户关注的所有店铺id集合
        List<Long> stores = mapper.selectIdsByUserId(request);
        if (stores == null || stores.isEmpty()) {
            return Collections.emptyList();  // 返回空列表
        }
        //2 拿到所有店铺信息
        List<StoreFocusResponse> list = mapper.getStoresById(stores);
        return list;
    }
}
