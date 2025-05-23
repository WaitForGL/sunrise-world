package com.september.store.service;

import com.september.store.domain.focus.request.MyFocusRequest;
import com.september.store.domain.focus.response.StoreFocusResponse;

import java.util.List;

public interface IStoreFocusService {
    List<StoreFocusResponse> myFocus(MyFocusRequest request);
}
