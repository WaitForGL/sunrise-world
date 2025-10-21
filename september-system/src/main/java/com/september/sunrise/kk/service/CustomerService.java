package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkCustomer;
import java.util.List;

public interface CustomerService {

    /**
     * 查询顾客名单列表
     */
    List<KkCustomer> customerList();
}
