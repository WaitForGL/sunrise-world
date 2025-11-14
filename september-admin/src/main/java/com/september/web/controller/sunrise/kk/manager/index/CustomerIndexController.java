package com.september.web.controller.sunrise.kk.manager.index;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.dto.CustomerIndexQueryDto;
import com.september.sunrise.kk.service.CustomerIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "顾客工作台统计")
@RestController
@RequestMapping("/customer/index")
public class CustomerIndexController {

    @Resource
    private CustomerIndexService customerIndexService;

    @GetMapping("/stats")
    @ApiOperation("获取顾客统计数据")
    public AjaxResult stats(@Validated @ModelAttribute CustomerIndexQueryDto dto) {
        return AjaxResult.success(customerIndexService.getStatistics(dto));
    }
}
