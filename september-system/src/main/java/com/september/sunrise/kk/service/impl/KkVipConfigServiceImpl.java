package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.september.sunrise.kk.domain.KkVipConfig;
import com.september.sunrise.kk.mapper.KkVipConfigMapper;
import com.september.sunrise.kk.service.KkVipConfigService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class KkVipConfigServiceImpl
        extends ServiceImpl<KkVipConfigMapper, KkVipConfig>
        implements KkVipConfigService {

    @Override
    public KkVipConfig calculateVipConfig(BigDecimal totalRecharge) {
        if (totalRecharge == null) return null;

        List<KkVipConfig> configs = this.list(
                new LambdaQueryWrapper<KkVipConfig>()
                        .orderByAsc(KkVipConfig::getRechargeThreshold)
        );

        KkVipConfig result = null;
        for (KkVipConfig config : configs) {
            if (totalRecharge.compareTo(config.getRechargeThreshold()) >= 0) {
                result = config;
            }
        }
        return result;
    }
}
