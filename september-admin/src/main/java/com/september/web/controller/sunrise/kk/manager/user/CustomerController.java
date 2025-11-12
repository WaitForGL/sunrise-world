package com.september.web.controller.sunrise.kk.customer;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.CustomerQueryDto;
import com.september.sunrise.kk.service.CustomerService;
import com.september.web.controller.common.domain.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "顾客管理")
@RestController
@RequestMapping("/kk/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * 获取顾客列表（分页 + 条件筛选）
     */
    @GetMapping("/list")
    @ApiOperation("获取顾客列表，可按条件筛选")
    public AjaxResult list(@Validated @ModelAttribute CustomerQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNo(), queryDto.getPageSize());
        List<KkUser> customers = customerService.getCustomerList(queryDto);

        PageInfo<KkUser> pageInfo = new PageInfo<>(customers);
        PageResult<KkUser> pageResult = PageResult.iPageHandle(
                pageInfo.getTotal(),
                queryDto.getPageNo().longValue(),
                queryDto.getPageSize().longValue(),
                pageInfo.getList()
        );

        return AjaxResult.success(pageResult);
    }

    @PostMapping("/add")
    @ApiOperation("新增顾客")
    public AjaxResult add(@RequestBody KkUser customer) {
        customerService.addCustomer(customer);
        return AjaxResult.success("新增顾客成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改顾客信息")
    public AjaxResult update(@RequestBody KkUser customer) {
        customerService.updateCustomer(customer);
        return AjaxResult.success("修改顾客成功");
    }

    @PostMapping("/delete")
    @ApiOperation("删除顾客")
    public AjaxResult delete(@RequestBody Long id) {
        customerService.deleteCustomer(id);
        return AjaxResult.success("删除顾客成功");
    }
}
