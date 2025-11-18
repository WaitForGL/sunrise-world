package com.september.web.controller.sunrise.kk.manager.order;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.service.KkOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "后台订单模块")
@RestController
@RequestMapping("/kk/order")
@RequiredArgsConstructor
public class OrderController {

    private final KkOrderService orderService;

    @GetMapping("/list")
    @ApiOperation("获取后台订单列表")
    public AjaxResult list() {
        List<KkOrder> orders = orderService.listOrders();
        return AjaxResult.success(orders);
    }

    @PostMapping("/update")
    @ApiOperation("更新订单信息")
    public AjaxResult update(@RequestBody KkOrder order) {
        orderService.updateOrder(order);
        return AjaxResult.success("更新成功");
    }

    @PostMapping("/delete")
    @ApiOperation("删除订单")
    public AjaxResult delete(@RequestParam Long id) {
        orderService.deleteOrder(id);
        return AjaxResult.success("删除成功");
    }
}
