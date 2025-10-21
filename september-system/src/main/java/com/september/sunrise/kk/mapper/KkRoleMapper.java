package com.september.sunrise.kk.mapper;

import com.september.sunrise.kk.domain.KkRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KkRoleMapper {
    List<KkRole> findByUserId(Long userId);
}

