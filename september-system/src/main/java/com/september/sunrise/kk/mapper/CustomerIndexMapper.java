package com.september.sunrise.kk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.september.sunrise.kk.domain.KkUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;

@Mapper
public interface CustomerIndexMapper extends BaseMapper<KkUser> {

    Long countCustomers(@Param("params") Map<String, Object> params);

    BigDecimal sumRechargeAmount(@Param("params") Map<String, Object> params);

    BigDecimal sumConsumeAmount(@Param("params") Map<String, Object> params);

    BigDecimal sumCustomerBalance(@Param("params") Map<String, Object> params);

}
