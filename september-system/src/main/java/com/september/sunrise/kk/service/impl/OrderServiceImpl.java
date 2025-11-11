package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.dto.OrderQueryDto;
import com.september.sunrise.kk.mapper.KkOrderMapper;
import com.september.sunrise.kk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private KkOrderMapper kkOrderMapper;

    @Override
    public List<KkOrder> getOrderList(OrderQueryDto queryDto) {
        LambdaQueryWrapper<KkOrder> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(queryDto.getStatus() != null, KkOrder::getStatus, queryDto.getStatus());
        wrapper.like(queryDto.getCustomerName() != null && !queryDto.getCustomerName().isEmpty(), KkOrder::getCustomerName, queryDto.getCustomerName());
        wrapper.like(queryDto.getPlaymateName() != null && !queryDto.getPlaymateName().isEmpty(), KkOrder::getPlaymateName, queryDto.getPlaymateName());
        wrapper.like(queryDto.getManagerName() != null && !queryDto.getManagerName().isEmpty(), KkOrder::getManagerName, queryDto.getManagerName());
        wrapper.eq(queryDto.getGameCategory() != null, KkOrder::getGameCategory, queryDto.getGameCategory());
        wrapper.ge(queryDto.getStartDate() != null, KkOrder::getOrderDate, queryDto.getStartDate());
        wrapper.le(queryDto.getEndDate() != null, KkOrder::getOrderDate, queryDto.getEndDate());
        wrapper.eq(KkOrder::getIsDelete, 0);
        wrapper.orderByDesc(KkOrder::getOrderDate);
        return kkOrderMapper.selectList(wrapper);
    }

    @Override
    public void addOrder(KkOrder order) {
        // 自动计算金额逻辑
        BigDecimal total = order.getUnitPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
        BigDecimal discounted = total.multiply(order.getDiscountRate());
        BigDecimal playmateIncome = discounted.multiply(order.getCommissionRate());
        BigDecimal storeIncome = discounted.subtract(playmateIncome);

        order.setTotalAmount(total);
        order.setDiscountedAmount(discounted);
        order.setPlaymateIncome(playmateIncome);
        order.setStoreIncome(storeIncome);

        kkOrderMapper.insert(order);
    }

    @Override
    public void updateOrder(KkOrder order) {
        kkOrderMapper.updateById(order);
    }

    @Override
    public void deleteOrder(Long id) {
        KkOrder order = new KkOrder();
        order.setId(id);
        order.setIsDelete(1);
        kkOrderMapper.updateById(order);
    }
}
