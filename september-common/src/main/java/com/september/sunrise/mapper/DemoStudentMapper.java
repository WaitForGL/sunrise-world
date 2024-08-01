package com.september.sunrise.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.september.sunrise.entity.demo.DemoStudent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoStudentMapper extends BaseMapper<DemoStudent> {
}
