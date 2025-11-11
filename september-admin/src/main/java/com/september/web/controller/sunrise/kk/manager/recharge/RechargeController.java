package com.september.web.controller.sunrise.kk.manager.recharge;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.dto.RechargeDto;
import com.september.sunrise.kk.service.RechargeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@Api(tags = "充值管理")
@RestController
@RequestMapping("/kk/recharge")
@RequiredArgsConstructor
public class RechargeController {

    private final RechargeService rechargeService;

    @PostMapping("/add")
    @ApiOperation("用户充值并自动升级VIP")
    public AjaxResult recharge(@RequestBody RechargeDto rechargeDto) {

        Long userId = rechargeDto.getUserId();
        BigDecimal amount = rechargeDto.getAmount();
        String remark = rechargeDto.getRemark() != null ? rechargeDto.getRemark() : "用户充值";

        rechargeService.recharge(userId, amount, remark);
        return AjaxResult.success("充值成功");
    }

}

