package com.september.sunrise.kk.service;

import com.september.sunrise.kk.domain.KkFundLog;
import java.util.Date;
import java.util.List;

public interface FundLogService {

    void addFundLog(KkFundLog log);

    List<KkFundLog> listFundLogs(Long userId, String role, Date startTime, Date endTime);

    String summary(Long userId, String role, String flowType, Date startTime, Date endTime);
}
