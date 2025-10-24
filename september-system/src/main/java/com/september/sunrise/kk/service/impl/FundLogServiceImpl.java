package com.september.sunrise.kk.service.impl;

import com.september.sunrise.kk.domain.KkFundLog;
import com.september.sunrise.kk.mapper.KkFundLogMapper;
import com.september.sunrise.kk.service.FundLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class FundLogServiceImpl implements FundLogService {

    @Resource
    private KkFundLogMapper fundLogMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addFundLog(KkFundLog log) {
        fundLogMapper.insertFundLog(log);
    }

    @Override
    public List<KkFundLog> listFundLogs(Long userId, String role, Date startTime, Date endTime) {
        return fundLogMapper.queryFundLogs(userId, role, startTime, endTime);
    }

    @Override
    public String summary(Long userId, String role, String flowType, Date startTime, Date endTime) {
        BigDecimal total = fundLogMapper.sumAmount(userId, role, flowType, startTime, endTime);
        return "总金额：" + total;
    }
}
