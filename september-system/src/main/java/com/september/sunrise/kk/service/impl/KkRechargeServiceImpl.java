package com.september.sunrise.kk.service.impl;

import com.september.sunrise.kk.domain.KkRechargeLog;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.domain.KkVipConfig;
import com.september.sunrise.kk.mapper.KkRechargeLogMapper;
import com.september.sunrise.kk.mapper.KkUserMapper;
import com.september.sunrise.kk.service.KkVipConfigService;
import com.september.sunrise.kk.service.KkRechargeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class KkRechargeServiceImpl implements KkRechargeService {

    private final KkUserMapper kkUserMapper;
    private final KkVipConfigService vipConfigService;
    private final KkRechargeLogMapper logMapper;

    @Override
    @Transactional
    public void recharge(Long userId, BigDecimal amount, String remark) {
        KkUser user = kkUserMapper.selectById(userId);
        if (user == null) throw new RuntimeException("用户不存在");

        BigDecimal beforeAmount = user.getTotalRecharge() == null ? BigDecimal.ZERO : user.getTotalRecharge();
        BigDecimal afterAmount = beforeAmount.add(amount);

        KkVipConfig vipConfig = vipConfigService.calculateVipConfig(afterAmount);
        Integer newVipLevel = vipConfig != null ? vipConfig.getVipLevel() : user.getVipLevel();
        String newVipName = vipConfig != null ? vipConfig.getVipName() : user.getVipName();

        // 更新用户VIP
        user.setTotalRecharge(afterAmount);
        user.setVipLevel(newVipLevel);
        user.setVipName(newVipName);
        kkUserMapper.updateUserVip(user);

        // 写入充值记录
        KkRechargeLog log = new KkRechargeLog();
        log.setUserId(userId);
        log.setAmount(amount);
        log.setBeforeAmount(beforeAmount);
        log.setAfterAmount(afterAmount);
        log.setVipBefore(user.getVipLevel());
        log.setVipAfter(newVipLevel);
        log.setRemark(remark);
        logMapper.insert(log);
    }
}
