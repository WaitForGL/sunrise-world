package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkOrder;

import java.util.List;

public interface OrderService {

    void placeOrder(KkOrder order);

    List<KkOrder> listOrdersByUser(Long userId);

    List<KkOrder> listOrders();

    void updateOrder(KkOrder order);

    void deleteOrder(Long id);
}
