package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.domain.KkPlaymateGame;
import com.september.sunrise.kk.mapper.KkOrderMapper;
import com.september.sunrise.kk.mapper.KkPlaymateGameMapper;
import com.september.sunrise.kk.service.KkOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KkOrderServiceImpl implements KkOrderService {

    private final KkOrderMapper orderMapper;
    private final KkPlaymateGameMapper playmateGameMapper;

    @Override
    public void placeOrder(KkOrder order) {
        if (order.getPlaymateId() == null) {
            // 自动派单
            List<KkPlaymateGame> candidates = playmateGameMapper.listByGameAndLevel(order.getGameId(), order.getPlaymateLevelId());
            KkPlaymateGame playmateGame = candidates.stream()
                    .filter(g -> g.getStatus() != null && g.getStatus() == 1)
                    .findFirst()
                    .orElse(null);

            if (playmateGame == null) throw new RuntimeException("没有可用陪玩");

            order.setPlaymateId(playmateGame.getPlaymateId());
            order.setPlaymateName(playmateGame.getPlaymateName());
            order.setUnitPrice(playmateGame.getPrice());
            order.setCommissionRate(playmateGame.getCommissionRate());
            order.setPlaymateLevelId(playmateGame.getLevelId());
            order.setPlaymateLevelName(playmateGame.getLevelName());
        } else {
            // 指定陪玩
            KkPlaymateGame playmateGame = playmateGameMapper.getByPlaymateAndGame(order.getPlaymateId(), order.getGameId());
            if (playmateGame == null || playmateGame.getStatus() != 1)
                throw new RuntimeException("指定陪玩不可用或接单中");
            order.setUnitPrice(playmateGame.getPrice());
            order.setCommissionRate(playmateGame.getCommissionRate());
            order.setPlaymateLevelId(playmateGame.getLevelId());
            order.setPlaymateLevelName(playmateGame.getLevelName());
            order.setPlaymateName(playmateGame.getPlaymateName());
        }

        // 计算金额
        BigDecimal total = order.getUnitPrice().multiply(BigDecimal.valueOf(order.getCount()));
        BigDecimal discounted = total.multiply(order.getDiscountRate());
        BigDecimal playmateIncome = discounted.multiply(order.getCommissionRate());
        BigDecimal storeIncome = discounted.subtract(playmateIncome);

        order.setTotalAmount(total);
        order.setDiscountedAmount(discounted);
        order.setPlaymateIncome(playmateIncome);
        order.setStoreIncome(storeIncome);
        order.setOrderNo("ORD" + System.currentTimeMillis());
        order.setOrderTime(LocalDateTime.now());
        order.setIsDelete(0);

        orderMapper.insert(order);
    }

    @Override
    public List<KkOrder> listOrdersByUser(Long userId) {
        LambdaQueryWrapper<KkOrder> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(KkOrder::getCustomerId, userId)
                .eq(KkOrder::getIsDelete, 0)
                .orderByDesc(KkOrder::getOrderTime);
        return orderMapper.selectList(wrapper);
    }

    @Override
    public List<KkOrder> listOrders() {
        LambdaQueryWrapper<KkOrder> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(KkOrder::getIsDelete, 0)
                .orderByDesc(KkOrder::getOrderTime);
        return orderMapper.selectList(wrapper);
    }

    @Override
    public void updateOrder(KkOrder order) {
        orderMapper.updateById(order);
    }

    @Override
    public void deleteOrder(Long id) {
        KkOrder order = new KkOrder();
        order.setId(id);
        order.setIsDelete(1);
        orderMapper.updateById(order);
    }
}
