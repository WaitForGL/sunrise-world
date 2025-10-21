// PlayMateController.java
package com.september.web.controller.sunrise.kk.manager.user;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/kk/playMate")
@Api(tags = {"后台陪玩模块"})
public class PlayMateController {

    @Resource
    private UserService userService;

    /**
     * 陪玩列表（完整字段）
     */
    @GetMapping("/playmateList")
    @ApiOperation("陪玩列表（完整字段）")
    public AjaxResult playmateList() {
        List<KkUser> playmates = userService.playmateList();
        return AjaxResult.success(playmates);
    }
}
