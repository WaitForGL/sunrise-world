package com.september.web.controller.sunrise.kk.manager.order;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkOrder;
import com.september.sunrise.kk.dto.OrderQuery;
import com.september.sunrise.kk.service.OrderService;
import com.september.web.controller.common.domain.PageResult;
import com.september.web.controller.common.domain.PageValidate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/kk/order")
@Api(tags = {"后台订单管理"})
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 消费订单列表（分页+条件查询）
     */
    @GetMapping("/list")
    @ApiOperation("消费订单列表（分页+条件查询）")
    public AjaxResult orderList(@Validated PageValidate pageValidate, OrderQuery query) {
        Integer page = pageValidate.getPageNo();
        Integer limit = pageValidate.getPageSize();

        // 启用分页
        PageHelper.startPage(page, limit);

        // 查询订单
        List<KkOrder> orders = orderService.orderList(query);

        // 分页结果封装
        PageInfo<KkOrder> pageInfo = new PageInfo<>(orders);
        PageResult<KkOrder> pageResult = PageResult.iPageHandle(
                pageInfo.getTotal(), page.longValue(), limit.longValue(), pageInfo.getList()
        );
        return AjaxResult.success(pageResult);
    }

    /**
     * 根据ID查询订单
     */
    @GetMapping("/getById")
    @ApiOperation("根据ID查询订单")
    public AjaxResult getById(@RequestParam Long id) {
        KkOrder order = orderService.getById(id);
        return AjaxResult.success(order);
    }

    /**
     * 新增订单
     */
    @PostMapping("/add")
    @ApiOperation("新增订单")
    public AjaxResult addOrder(@RequestBody KkOrder order) {
        orderService.addOrder(order);
        return AjaxResult.success("新增订单成功");
    }

    /**
     * 审核订单（确认报单）
     */
    @PostMapping("/audit")
    @ApiOperation("审核订单（确认报单）")
    public AjaxResult auditOrder(@RequestBody KkOrder order) {
        orderService.auditOrder(order);
        return AjaxResult.success("订单审核成功");
    }


    /**
     * 编辑订单
     */
    @PostMapping("/update")
    @ApiOperation("编辑订单")
    public AjaxResult updateOrder(@RequestBody KkOrder order) {
        orderService.updateOrder(order);
        return AjaxResult.success("编辑订单成功");
    }

    /**
     * 逻辑删除订单（标记删除）
     */
    @PostMapping("/removeOrder")
    @ApiOperation("逻辑删除订单（标记删除）")
    public AjaxResult removeOrder(@RequestParam Long id) {
        orderService.removeOrder(id);
        return AjaxResult.success("逻辑删除订单成功");
    }

    /**
     * 物理删除订单（彻底删除）
     */
    @PostMapping("/deleteOrder")
    @ApiOperation("物理删除订单（彻底删除）")
    public AjaxResult deleteOrder(@RequestParam Long id) {
        orderService.deleteOrder(id);
        return AjaxResult.success("物理删除订单成功");
    }
}
