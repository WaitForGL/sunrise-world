package com.september.web.controller.sunrise.kk.manager.order;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.dto.OrderQueryDto;
import com.september.sunrise.kk.service.OrderService;
import com.september.web.controller.common.domain.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "订单管理")
@RestController
@RequestMapping("/kk/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/list")
    @ApiOperation("获取订单列表，可筛选条件")
    public AjaxResult list(@Validated @ModelAttribute OrderQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNo(), queryDto.getPageSize());
        List<KkOrder> orders = orderService.getOrderList(queryDto);
        PageInfo<KkOrder> pageInfo = new PageInfo<>(orders);
        PageResult<KkOrder> pageResult = PageResult.iPageHandle(
                pageInfo.getTotal(),
                queryDto.getPageNo().longValue(),
                queryDto.getPageSize().longValue(),
                pageInfo.getList()
        );
        return AjaxResult.success(pageResult);
    }


    @PostMapping("/add")
    @ApiOperation("新增订单")
    public AjaxResult add(@RequestBody KkOrder order) {
        orderService.addOrder(order);
        return AjaxResult.success("新增订单成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改订单")
    public AjaxResult update(@RequestBody KkOrder order) {
        orderService.updateOrder(order);
        return AjaxResult.success("修改订单成功");
    }

    @PostMapping("/delete")
    @ApiOperation("删除订单（逻辑删除）")
    public AjaxResult delete(@RequestBody Long id) {
        orderService.deleteOrder(id);
        return AjaxResult.success("删除订单成功");
    }
}
