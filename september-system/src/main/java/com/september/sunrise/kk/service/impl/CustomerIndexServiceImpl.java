package com.september.sunrise.kk.service.customer.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.CustomerIndexQueryDto;
import com.september.sunrise.kk.mapper.CustomerIndexMapper;
import com.september.sunrise.kk.service.CustomerIndexService;
import com.september.sunrise.kk.vo.CustomerIndexVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerIndexServiceImpl
        extends ServiceImpl<CustomerIndexMapper, KkUser>
        implements CustomerIndexService {

    @Resource
    private CustomerIndexMapper customerIndexMapper;

    @Override
    public CustomerIndexVO getStatistics(CustomerIndexQueryDto dto) {

        Map<String, Object> params = new HashMap<>();
        params.put("startDate", dto.getStartDate());
        params.put("endDate", dto.getEndDate());
        params.put("rechargeStatus", dto.getRechargeStatus());
        params.put("orderStatus", dto.getOrderStatus());

        CustomerIndexVO vo = new CustomerIndexVO();

        vo.setCustomerCount(customerIndexMapper.countCustomers(params));
        vo.setTotalRechargeAmount(customerIndexMapper.sumRechargeAmount(params));
        vo.setTotalConsumeAmount(customerIndexMapper.sumConsumeAmount(params));
        vo.setTotalBalanceAmount(customerIndexMapper.sumCustomerBalance(params));

        return vo;
    }
}
