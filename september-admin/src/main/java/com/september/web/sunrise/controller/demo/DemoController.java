package com.september.web.sunrise.controller.demo;

import com.github.pagehelper.PageHelper;
import com.september.common.core.domain.AjaxResult;
import com.september.common.core.domain.PageResult;
import com.september.sunrise.entity.commons.PageValidate;
import com.september.sunrise.entity.demo.DemoStudent;
import com.september.sunrise.entity.demo.request.DemoStudentRequest;
import com.september.sunrise.utils.excel.ExcelUtils;
import com.september.web.sunrise.service.demo.IDemoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
    public AjaxResult add(@Validated @RequestBody DemoStudent request) {
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

    /**
     * 批量导入测试数据
     * @param file
     * @return
     */
    @PostMapping("/excelDemoStudent")
    public AjaxResult excelDemoStudent(@RequestPart("file") MultipartFile file) throws Exception{
        //excel数据解析
        List<DemoStudent> demoStudents = ExcelUtils.readMultipartFile(file, DemoStudent.class);
        for(DemoStudent demoStudent : demoStudents){
            //部分字段新增属性内容 例如
            demoStudent.setStuName("新增属性");
            demoService.add(demoStudent);

        }
        return AjaxResult.success("导入完成");
    }

    /**
     * 批量导出测试数据
     * @param response
     * @return
     */
    @GetMapping("/exportDemoStudent")
    public void exportDemoStudent(HttpServletResponse response, DemoStudentRequest request){
        List<DemoStudent> list = demoService.pageList(request);
        ExcelUtils.export(response,"测试数据表",list,DemoStudent.class);


    }


}
