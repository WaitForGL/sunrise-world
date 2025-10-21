package com.september.sunrise.kk.mapper;

import com.september.sunrise.kk.domain.KkCustomer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KkCustomerMapper {

    /**
     * 查询所有顾客名单
     */
    List<KkCustomer> findAllCustomers();
}
