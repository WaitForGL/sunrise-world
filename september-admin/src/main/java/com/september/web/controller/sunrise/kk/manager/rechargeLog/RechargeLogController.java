package com.september.web.controller.sunrise.kk.manager.rechargeLog;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.september.common.core.domain.AjaxResult;
import com.september.web.controller.common.domain.PageResult;
import com.september.sunrise.kk.domain.KkRechargeLog;
import com.september.sunrise.kk.dto.RechargeLogQueryDto;
import com.september.sunrise.kk.service.RechargeLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "充值流水查询")
@RestController
@RequestMapping("/kk/rechargeLog")
@RequiredArgsConstructor
public class RechargeLogController {

    private final RechargeLogService rechargeLogService;

    @GetMapping("/list")
    @ApiOperation("分页查询充值流水")
    public AjaxResult list(@Validated @ModelAttribute RechargeLogQueryDto queryDto) {

        Page<KkRechargeLog> page = new Page<>(queryDto.getPageNo(), queryDto.getPageSize());
        LambdaQueryWrapper<KkRechargeLog> wrapper = new LambdaQueryWrapper<>();
        if (queryDto.getUserId() != null) {
            wrapper.eq(KkRechargeLog::getUserId, queryDto.getUserId());
        }
        if (queryDto.getStartTime() != null) {
            wrapper.ge(KkRechargeLog::getCreateTime, queryDto.getStartTime());
        }
        if (queryDto.getEndTime() != null) {
            wrapper.le(KkRechargeLog::getCreateTime, queryDto.getEndTime());
        }
        wrapper.orderByDesc(KkRechargeLog::getCreateTime);

        Page<KkRechargeLog> result = rechargeLogService.page(page, wrapper);
        PageResult<KkRechargeLog> pageResult = PageResult.iPageHandle(result.getTotal(), queryDto.getPageNo(),
                queryDto.getPageSize(), result.getRecords());

        return AjaxResult.success(pageResult);
    }
}
