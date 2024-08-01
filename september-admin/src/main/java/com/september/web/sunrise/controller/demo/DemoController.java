package com.september.web.sunrise.controller.demo;

import com.github.pagehelper.PageHelper;
import com.september.common.core.domain.AjaxResult;
import com.september.common.core.domain.PageResult;
import com.september.sunrise.entity.commons.PageValidate;
import com.september.sunrise.entity.demo.DemoStudent;
import com.september.sunrise.entity.demo.request.DemoStudentRequest;
import com.september.sunrise.entity.demo.response.DemoStudentResponse;
import com.september.web.sunrise.service.IDemoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/manage/demo")
public class DemoController {

    @Resource
    private IDemoService demoService;

    @GetMapping("/pageList")
    @ApiOperation(value = "测试数据列表")
    public AjaxResult pageList(@Validated PageValidate pageValidate, DemoStudentRequest request) {
        Integer page = pageValidate.getPageNo();
        Integer limit = pageValidate.getPageSize();
        PageHelper.startPage(page, limit);
        List<DemoStudent> list = demoService.pageList(request);
        PageResult<DemoStudent> pageResult = PageResult.pageHelper(list);
        return AjaxResult.success("示例数据分页返回", pageResult);
    }

    @ApiOperation(value = "测试数据列表新增")
    @PostMapping("/add")
    public AjaxResult add(@Validated @RequestBody DemoStudentRequest request) {
        demoService.add(request);
        return AjaxResult.success("新增成功");
    }

    @ApiOperation(value = "测试数据列表修改")
    @PostMapping("/edit")
    public AjaxResult edit(@Validated @RequestBody DemoStudentRequest request) {
        demoService.edit(request);
        return AjaxResult.success("修改成功");
    }

    @ApiOperation(value = "测试数据列表逻辑删除")
    @PostMapping("/remove")
    public AjaxResult removeData(@Validated @RequestBody DemoStudentRequest request) {
        demoService.removeData(request);
        return AjaxResult.success("删除成功");
    }
}
