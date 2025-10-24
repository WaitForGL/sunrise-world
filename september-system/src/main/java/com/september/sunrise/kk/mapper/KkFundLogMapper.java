package com.september.sunrise.kk.mapper;

import com.september.sunrise.kk.domain.KkFundLog;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface KkFundLogMapper {

    int insertFundLog(KkFundLog fundLog);

    List<KkFundLog> queryFundLogs(@Param("userId") Long userId,
                                  @Param("role") String role,
                                  @Param("startTime") Date startTime,
                                  @Param("endTime") Date endTime);

    BigDecimal sumAmount(@Param("userId") Long userId,
                         @Param("role") String role,
                         @Param("flowType") String flowType,
                         @Param("startTime") Date startTime,
                         @Param("endTime") Date endTime);
}
