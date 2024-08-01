package com.september.web.sunrise.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.september.sunrise.entity.demo.DemoStudent;
import com.september.sunrise.entity.demo.request.DemoStudentRequest;
import com.september.sunrise.mapper.DemoStudentMapper;
import com.september.web.sunrise.service.IDemoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl extends ServiceImpl<DemoStudentMapper, DemoStudent> implements IDemoService {
    @Override
    public List<DemoStudent> pageList(DemoStudentRequest request) {
        LambdaQueryWrapper<DemoStudent> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DemoStudent::getIsDelete,0);
        List<DemoStudent> list = baseMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public void add(DemoStudentRequest request) {
        DemoStudent demoStudent = new DemoStudent();
        demoStudent.setId(request.getId());
        baseMapper.insert(demoStudent);
    }

    @Override
    public void edit(DemoStudentRequest request) {
        DemoStudent demoStudent = new DemoStudent();
        demoStudent.setId(request.getId());
        baseMapper.updateById(demoStudent);
    }

    @Override
    public void removeData(DemoStudentRequest request) {
        DemoStudent demoStudent = new DemoStudent();
        demoStudent.setId(request.getId());
        request.setIsDelete(1);
        baseMapper.updateById(demoStudent);
    }
}
