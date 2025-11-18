package com.september.web.controller.sunrise.kk.manager.playgame;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkPlaymateGame;
import com.september.sunrise.kk.service.KkPlaymateGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "陪玩游戏配置管理")
@RestController
@RequestMapping("/kk/playmate/game")
public class PlaymateGameManageController {

    @Resource
    private KkPlaymateGameService playmateGameService;

    @GetMapping("/list")
    @ApiOperation("获取陪玩支持的游戏与价格")
    public AjaxResult list(@RequestParam Long playmateId) {
        List<KkPlaymateGame> games = playmateGameService.listByPlaymate(playmateId);
        return AjaxResult.success(games);
    }

    @PostMapping("/add")
    @ApiOperation("新增陪玩游戏配置")
    public AjaxResult add(@RequestBody KkPlaymateGame game) {
        playmateGameService.addPlaymateGame(game);
        return AjaxResult.success("新增成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改陪玩游戏配置")
    public AjaxResult update(@RequestBody KkPlaymateGame game) {
        playmateGameService.updatePlaymateGame(game);
        return AjaxResult.success("修改成功");
    }

    @PostMapping("/delete")
    @ApiOperation("删除陪玩游戏配置")
    public AjaxResult delete(@RequestBody Long id) {
        playmateGameService.deletePlaymateGame(id);
        return AjaxResult.success("删除成功");
    }

}
