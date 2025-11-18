package com.september.web.controller.sunrise.kk.wechat;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkGameCategory;
import com.september.sunrise.kk.service.KkGameCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "前台游戏分类模块")
@RestController
@RequestMapping("/wechat/category")
public class GameCategoryController {

    @Resource
    private KkGameCategoryService categoryService;

    @GetMapping("/list")
    @ApiOperation("获取游戏分类列表")
    public AjaxResult list() {
        List<KkGameCategory> list = categoryService.listEnabledCategories();
        return AjaxResult.success(list);
    }
}
