package com.september.web.sunrise.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.september.sunrise.entity.demo.DemoStudent;
import com.september.sunrise.entity.demo.request.DemoStudentRequest;
import com.september.sunrise.entity.demo.response.DemoStudentResponse;

import java.util.List;

public interface IDemoService extends IService<DemoStudent> {
    List<DemoStudent> pageList(DemoStudentRequest goods);

    void add(DemoStudentRequest request);

    void edit(DemoStudentRequest request);

    void removeData(DemoStudentRequest request);
}
