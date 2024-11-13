package com.september.web.sunrise.service.demo.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.september.sunrise.utils.StringUtils;
import com.september.sunrise.entity.demo.DemoStudent;
import com.september.sunrise.entity.demo.request.DemoStudentRequest;
import com.september.sunrise.mapper.demo.DemoStudentMapper;
import com.september.web.sunrise.service.demo.IDemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl extends ServiceImpl<DemoStudentMapper, DemoStudent> implements IDemoService {
    @Override
    public List<DemoStudent> pageList(DemoStudentRequest request) {
        LambdaQueryWrapper<DemoStudent> studentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        studentLambdaQueryWrapper.eq(StringUtils.isNotEmpty(request.getStuName()), DemoStudent::getStuName, request.getStuName());
        studentLambdaQueryWrapper.orderByDesc(DemoStudent::getId);
        List<DemoStudent> list = baseMapper.selectList(studentLambdaQueryWrapper);
        return list;
    }

    @Override
    public void add(DemoStudent request) {

    }

    @Override
    public void edit(DemoStudentRequest request) {

    }

    @Override
    public void removeData(DemoStudentRequest request) {

    }
}
