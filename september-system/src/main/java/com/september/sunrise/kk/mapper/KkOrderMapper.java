package com.september.sunrise.kk.mapper;

import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.dto.OrderQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KkOrderMapper {

    /**
     * 条件查询订单列表
     */
    List<KkOrder> findOrders(OrderQuery query);

    /**
     * 根据ID查询订单
     */
    KkOrder findById(@Param("id") Long id);

    /**
     * 新增订单
     */
    int insertOrder(KkOrder order);

    /**
     * 编辑订单
     */
    int updateOrder(KkOrder order);

    /**
     * 逻辑删除订单（is_delete = 1）
     */
    int removeOrderById(@Param("id") Long id);

    /**
     * 物理删除订单（真实删除）
     */
    int deleteOrderById(@Param("id") Long id);
}
