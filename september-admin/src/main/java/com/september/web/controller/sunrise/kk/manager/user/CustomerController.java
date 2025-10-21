// CustomerController.java
package com.september.web.controller.sunrise.kk.manager.user;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkCustomer;
import com.september.sunrise.kk.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/kk/customer")
@Api(tags = {"后台顾客管理"})
public class CustomerController {

    @Resource
    private CustomerService customerService;

    /**
     * 顾客名单列表
     */
    @GetMapping("/list")
    @ApiOperation("顾客名单列表")
    public AjaxResult customerList() {
        List<KkCustomer> customers = customerService.customerList();
        return AjaxResult.success(customers);
    }


}
