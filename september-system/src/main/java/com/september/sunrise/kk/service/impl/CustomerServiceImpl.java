package com.september.sunrise.kk.service.impl;

import com.september.sunrise.kk.domain.KkCustomer;
import com.september.sunrise.kk.mapper.KkCustomerMapper;
import com.september.sunrise.kk.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private KkCustomerMapper customerMapper;

    @Override
    public List<KkCustomer> customerList() {
        return customerMapper.findAllCustomers();
    }
}
