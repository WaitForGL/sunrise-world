package com.september.web.controller.sunrise.kk.wechat;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "前台订单模块")
@RestController
@RequestMapping("/wechat/order")
@RequiredArgsConstructor
public class WechatOrderController {

    private final OrderService orderService;

    @GetMapping("/list")
    @ApiOperation("获取当前用户订单列表")
    public AjaxResult list(@RequestParam Long userId) {
        List<KkOrder> orders = orderService.listOrdersByUser(userId);
        return AjaxResult.success(orders);
    }

    @PostMapping("/add")
    @ApiOperation("顾客下单/派单")
    public AjaxResult add(@RequestBody KkOrder order) {
        orderService.placeOrder(order);
        return AjaxResult.success("下单成功");
    }
}
