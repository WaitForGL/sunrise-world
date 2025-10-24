package com.september.web.controller.sunrise.kk.manager.fund;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkFundLog;
import com.september.sunrise.kk.service.FundLogService;
import com.september.web.controller.common.domain.PageResult;
import com.september.web.controller.common.domain.PageValidate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/kk/fund")
@Api(tags = {"后台资金流水管理"})
public class FundLogController {

    @Resource
    private FundLogService fundLogService;

    /**
     * 查询资金流水列表（分页 + 条件）
     */
    @GetMapping("/list")
    @ApiOperation("查询资金流水列表（分页 + 条件）")
    public AjaxResult list(@Validated PageValidate pageValidate,
                           @RequestParam(required = false) Long userId,
                           @RequestParam(required = false) String role,
                           @RequestParam(required = false) Date startTime,
                           @RequestParam(required = false) Date endTime) {

        PageHelper.startPage(pageValidate.getPageNo(), pageValidate.getPageSize());
        List<KkFundLog> list = fundLogService.listFundLogs(userId, role, startTime, endTime);
        PageInfo<KkFundLog> pageInfo = new PageInfo<>(list);
        PageResult<KkFundLog> pageResult = PageResult.iPageHandle(
                pageInfo.getTotal(),
                pageValidate.getPageNo().longValue(),
                pageValidate.getPageSize().longValue(),
                pageInfo.getList()
        );
        return AjaxResult.success(pageResult);
    }

    /**
     * 资金汇总统计
     */
    @GetMapping("/summary")
    @ApiOperation("资金汇总统计")
    public AjaxResult summary(@RequestParam Long userId,
                              @RequestParam String role,
                              @RequestParam String flowType,
                              @RequestParam(required = false) Date startTime,
                              @RequestParam(required = false) Date endTime) {
        return AjaxResult.success(fundLogService.summary(userId, role, flowType, startTime, endTime));
    }
}
