package com.september.sunrise.kk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.september.sunrise.kk.domain.KkRechargeLog;
import com.september.sunrise.kk.mapper.KkRechargeLogMapper;
import com.september.sunrise.kk.service.RechargeLogService;
import org.springframework.stereotype.Service;

@Service
public class RechargeLogServiceImpl extends ServiceImpl<KkRechargeLogMapper, KkRechargeLog>
        implements RechargeLogService {}
