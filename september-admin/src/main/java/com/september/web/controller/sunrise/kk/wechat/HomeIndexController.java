package com.september.web.controller.sunrise.kk.wechat;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.service.KkHomeIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "前台首页模块")
@RestController
@RequestMapping("/kk/home")
@RequiredArgsConstructor
public class HomeIndexController {

    private final KkHomeIndexService homeIndexService;

    @GetMapping("/index")
    @ApiOperation("获取首页展示数据")
    public AjaxResult index() {
        return AjaxResult.success(homeIndexService.getHomeIndex());
    }
}
