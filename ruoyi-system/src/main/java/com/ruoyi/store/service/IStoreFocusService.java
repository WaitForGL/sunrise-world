package com.ruoyi.store.service;

import com.ruoyi.store.domain.focus.request.MyFocusRequest;
import com.ruoyi.store.domain.focus.response.StoreFocusResponse;

import java.util.List;

public interface IStoreFocusService {
    List<StoreFocusResponse> myFocus(MyFocusRequest request);
}
