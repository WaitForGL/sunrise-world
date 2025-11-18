package com.september.web.controller.sunrise.kk.wechat;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.service.KkPlaymateGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "前台陪玩模块")
@RestController
@RequestMapping("/wechat/playmate")
@RequiredArgsConstructor
public class PlaymateGameController {

    private final KkPlaymateGameService playmateGameService;

    @GetMapping("/list")
    @ApiOperation("获取指定陪玩可接游戏及价格")
    public AjaxResult list(@RequestParam Long playmateId) {
        return AjaxResult.success(playmateGameService.listByPlaymate(playmateId));
    }
}
