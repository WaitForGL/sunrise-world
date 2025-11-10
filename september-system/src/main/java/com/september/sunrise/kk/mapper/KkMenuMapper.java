package com.september.sunrise.kk.mapper;

import com.september.sunrise.kk.domain.KkMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KkMenuMapper {
    List<KkMenu> selectMenusByRole(@Param("roleCode") String roleCode);
}
