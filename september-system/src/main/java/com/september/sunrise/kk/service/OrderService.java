package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.dto.OrderQueryDto;

import java.util.List;

public interface OrderService {

    List<KkOrder> getOrderList(OrderQueryDto queryDto);

    void addOrder(KkOrder order);

    void updateOrder(KkOrder order);

    void deleteOrder(Long id);
}
