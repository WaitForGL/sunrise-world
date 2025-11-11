package com.september.web.controller.sunrise.kk.manager.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkVipConfig;
import com.september.sunrise.kk.service.KkVipConfigService;
import com.september.web.controller.common.domain.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "VIP等级配置管理")
@RestController
@RequestMapping("/kk/vip/config")
public class VipConfigController {

    @Autowired
    private KkVipConfigService vipConfigService;

    @GetMapping("/list")
    @ApiOperation("分页查询VIP等级配置")
    public AjaxResult list(@RequestParam(value = "pageNo", defaultValue = "1") Long pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "10") Long pageSize) {

        Page<KkVipConfig> page = new Page<>(pageNo, pageSize);
        Page<KkVipConfig> result = vipConfigService.page(page, new LambdaQueryWrapper<KkVipConfig>()
                .orderByAsc(KkVipConfig::getVipLevel));
        PageResult<KkVipConfig> pageResult = PageResult.iPageHandle(result.getTotal(), pageNo, pageSize, result.getRecords());
        return AjaxResult.success(pageResult);
    }

    @ApiOperation("新增或修改VIP配置")
    @PostMapping("/save")
    public AjaxResult save(@RequestBody KkVipConfig config) {
        vipConfigService.saveOrUpdate(config);
        return AjaxResult.success("保存成功");
    }

    @ApiOperation("删除VIP配置")
    @PostMapping("/delete")
    public AjaxResult delete(@RequestParam Long id) {
        vipConfigService.removeById(id);
        return AjaxResult.success("删除成功");
    }
}
