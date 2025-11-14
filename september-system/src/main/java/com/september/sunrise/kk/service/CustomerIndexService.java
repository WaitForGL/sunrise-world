package com.september.sunrise.kk.service;


import com.september.sunrise.kk.dto.CustomerIndexQueryDto;
import com.september.sunrise.kk.vo.CustomerIndexVO;

public interface CustomerIndexService {

    CustomerIndexVO getStatistics(CustomerIndexQueryDto dto);

}
