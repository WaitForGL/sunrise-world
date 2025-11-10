package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.CustomerQueryDto;

import java.util.List;

public interface CustomerService {

    /**
     * 获取顾客列表（分页 + 条件筛选）
     */
    List<KkUser> getCustomerList(CustomerQueryDto queryDto);

    /**
     * 新增顾客
     */
    void addCustomer(KkUser user);

    /**
     * 修改顾客信息
     */
    void updateCustomer(KkUser user);

    /**
     * 删除顾客（逻辑删除）
     */
    void deleteCustomer(Long id);
}
