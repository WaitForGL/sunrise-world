package com.september.sunrise.kk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.september.sunrise.kk.domain.KkVipConfig;

import java.math.BigDecimal;

public interface KkVipConfigService extends IService<KkVipConfig> {

    /**
     * 根据累计充值金额，返回对应的 VIP 配置
     */
    KkVipConfig calculateVipConfig(BigDecimal totalRecharge);
}
