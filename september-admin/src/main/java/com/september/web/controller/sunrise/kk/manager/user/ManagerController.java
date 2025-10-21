// ManagerController.java
package com.september.web.controller.sunrise.kk.manager.user;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.AdminQuery;
import com.september.sunrise.kk.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/kk/manager")
@Api(tags = {"后台管理员模块"})
public class ManagerController {

    @Resource
    private UserService userService;

    /**
     * 管理员列表（部分字段 + 派单量）
     */
    @GetMapping("/adminList")
    @ApiOperation("管理员列表（部分字段 + 派单量）")
    public AjaxResult adminList() {
        List<KkUser> admins = userService.adminList();
        return AjaxResult.success(admins);
    }

    /**
     * 条件查询管理员
     */
    @GetMapping("/search")
    @ApiOperation("条件查询管理员")
    public AjaxResult searchAdmins(AdminQuery query) {
        List<KkUser> admins = userService.findAdminsByKeyword(query.getKeyword());
        return AjaxResult.success(admins);
    }

    /**
     * 新增管理员
     */
    @PostMapping("/add")
    @ApiOperation("新增管理员")
    public AjaxResult addAdmin(@RequestBody KkUser user) {
        userService.addAdmin(user);
        return AjaxResult.success("新增管理员成功");
    }

    /**
     * 编辑管理员
     */
    @PostMapping("/update")
    @ApiOperation("编辑管理员")
    public AjaxResult updateAdmin(@RequestBody KkUser user) {
        userService.updateAdmin(user);
        return AjaxResult.success("更新管理员成功");
    }

    /**
     * 逻辑删除管理员
     */
    @PostMapping("/removeManager")
    @ApiOperation("逻辑删除管理员")
    public AjaxResult removeManager(@RequestParam Long id) {
        userService.removeManager(id);
        return AjaxResult.success("逻辑删除成功");
    }

    /**
     * 物理删除管理员
     */
    @PostMapping("/deleteManager")
    @ApiOperation("物理删除管理员")
    public AjaxResult deleteManager(@RequestParam Long id) {
        userService.deleteManager(id);
        return AjaxResult.success("物理删除成功");
    }


}
