package com.september.web.sunrise.service.demo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.september.sunrise.entity.demo.DemoStudent;
import com.september.sunrise.entity.demo.request.DemoStudentRequest;

import java.util.List;

public interface IDemoService extends IService<DemoStudent> {
    List<DemoStudent> pageList(DemoStudentRequest goods);

    void add(DemoStudent request);

    void edit(DemoStudentRequest request);

    void removeData(DemoStudentRequest request);

}
