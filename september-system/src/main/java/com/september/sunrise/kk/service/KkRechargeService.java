package com.september.sunrise.kk.service;

import java.math.BigDecimal;

public interface KkRechargeService {
    void recharge(Long userId, BigDecimal amount, String remark);
}

