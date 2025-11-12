package com.september.web.controller.sunrise.kk.manager.user;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.PlaymateQueryDto;
import com.september.sunrise.kk.service.PlaymateService;
import com.september.web.controller.common.domain.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "陪玩管理")
@RestController
@RequestMapping("/kk/playmate")
@RequiredArgsConstructor
public class PlaymateController {

    private final PlaymateService playmateService;

    @GetMapping("/list")
    @ApiOperation("获取陪玩列表，可按条件筛选")
    public AjaxResult list(@Validated @ModelAttribute PlaymateQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNo(), queryDto.getPageSize());
        List<KkUser> playmates = playmateService.getPlaymateList(queryDto);

        PageInfo<KkUser> pageInfo = new PageInfo<>(playmates);
        PageResult<KkUser> pageResult = PageResult.iPageHandle(
                pageInfo.getTotal(),
                queryDto.getPageNo().longValue(),
                queryDto.getPageSize().longValue(),
                pageInfo.getList()
        );

        return AjaxResult.success(pageResult);
    }

    @PostMapping("/add")
    @ApiOperation("新增陪玩")
    public AjaxResult add(@RequestBody KkUser playmate) {
        playmateService.addPlaymate(playmate);
        return AjaxResult.success("新增陪玩成功");
    }

    @PostMapping("/update")
    @ApiOperation("修改陪玩信息")
    public AjaxResult update(@RequestBody KkUser playmate) {
        playmateService.updatePlaymate(playmate);
        return AjaxResult.success("修改陪玩成功");
    }

    @PostMapping("/delete")
    @ApiOperation("删除陪玩")
    public AjaxResult delete(@RequestBody Long id) {
        playmateService.deletePlaymate(id);
        return AjaxResult.success("删除陪玩成功");
    }

    @PostMapping("/leave")
    @ApiOperation("陪玩离职")
    public AjaxResult leave(@RequestBody Long id) {
        playmateService.leavePlaymate(id);
        return AjaxResult.success("陪玩已离职");
    }
}

