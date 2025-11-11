package com.september.sunrise.kk.service;

import java.math.BigDecimal;

public interface RechargeService {
    void recharge(Long userId, BigDecimal amount, String remark);
}

