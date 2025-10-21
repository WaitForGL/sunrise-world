package com.september.sunrise.kk.service.impl;

import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.dto.OrderQuery;
import com.september.sunrise.kk.mapper.KkOrderMapper;
import com.september.sunrise.kk.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private KkOrderMapper orderMapper;

    @Override
    public List<KkOrder> orderList(OrderQuery query) {
        return orderMapper.findOrders(query);
    }

    @Override
    public KkOrder getById(Long id) {
        return orderMapper.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrder(KkOrder order) {
        orderMapper.insertOrder(order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(KkOrder order) {
        int result = orderMapper.updateOrder(order);
        if (result == 0) {
            throw new RuntimeException("编辑订单失败，ID不存在或已删除");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeOrder(Long id) {
        int result = orderMapper.removeOrderById(id);
        if (result == 0) {
            throw new RuntimeException("逻辑删除订单失败，ID不存在或已删除");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrder(Long id) {
        int result = orderMapper.deleteOrderById(id);
        if (result == 0) {
            throw new RuntimeException("物理删除订单失败，ID不存在");
        }
    }
}
