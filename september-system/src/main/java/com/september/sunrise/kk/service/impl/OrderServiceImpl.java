package com.september.sunrise.kk.service.impl;

import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.dto.OrderQuery;
import com.september.sunrise.kk.mapper.KkCustomerMapper;
import com.september.sunrise.kk.mapper.KkOrderMapper;
import com.september.sunrise.kk.mapper.KkUserMapper;
import com.september.sunrise.kk.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private KkOrderMapper orderMapper;

    @Resource
    private KkCustomerMapper customerMapper;

    @Resource
    private KkUserMapper userMapper;




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
    public void auditOrder(KkOrder order) {
        // 1. 查询订单
        KkOrder dbOrder = orderMapper.findById(order.getId());
        if (dbOrder == null || dbOrder.getIsDelete() == 1) {
            throw new RuntimeException("订单不存在或已删除");
        }

        // 2. 检查是否已经审核
        if (dbOrder.getReportConfirmStatus() != null && dbOrder.getReportConfirmStatus() == 1) {
            throw new RuntimeException("该订单已审核确认");
        }

        // 3. 更新订单状态为已审核、已完成
        int result = orderMapper.auditOrder(order.getId());
        if (result == 0) {
            throw new RuntimeException("订单审核失败");
        }

        // 4. 扣除顾客余额
        if (dbOrder.getCustomerId() != null && dbOrder.getTotalAfterDiscount() != null
                && dbOrder.getTotalAfterDiscount().compareTo(BigDecimal.ZERO) > 0) {
            int deduct = customerMapper.decreaseRemainingBalance(dbOrder.getCustomerId(), dbOrder.getTotalAfterDiscount());
            if (deduct == 0) {
                throw new RuntimeException("顾客余额不足或扣除失败");
            }
        }

        // 5. 更新陪玩收入
        if (dbOrder.getPlaymateId() != null && dbOrder.getPlaymateIncome() != null
                && dbOrder.getPlaymateIncome().compareTo(BigDecimal.ZERO) > 0) {
            userMapper.updatePlaymateIncome(dbOrder.getPlaymateId(), dbOrder.getPlaymateIncome());
        }
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
