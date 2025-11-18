package com.september.web.controller.sunrise.kk.wechat;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkGame;
import com.september.sunrise.kk.service.KkGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "前台游戏单模块")
@RestController
@RequestMapping("/wechat/game")
public class GameController {

    @Resource
    private KkGameService gameService;

    @GetMapping("/list")
    @ApiOperation("根据分类ID获取游戏单列表")
    public AjaxResult list(@RequestParam Long categoryId) {
        List<KkGame> list = gameService.listByCategory(categoryId);
        return AjaxResult.success(list);
    }
}
