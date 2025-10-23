package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.dto.OrderQuery;

import java.util.List;

public interface OrderService {

    /**
     * 分页+条件查询订单列表
     */
    List<KkOrder> orderList(OrderQuery query);

    /**
     * 根据ID查询订单
     */
    KkOrder getById(Long id);

    /**
     * 新增订单
     */
    void addOrder(KkOrder order);

    /**
     * 编辑订单
     */
    void updateOrder(KkOrder order);

    /**
     * 逻辑删除订单
     */
    void removeOrder(Long id);

    /**
     * 物理删除订单
     */
    void deleteOrder(Long id);

    void auditOrder(KkOrder order);
}
