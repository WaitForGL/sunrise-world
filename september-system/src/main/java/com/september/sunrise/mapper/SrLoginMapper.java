package com.september.sunrise.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.september.sunrise.domain.user.SrUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SrLoginMapper extends BaseMapper<SrUser> {
}
