package com.september.web.controller.sunrise.kk.manager.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.ManagerQueryDto;
import com.september.sunrise.kk.service.KkManagerService;
import com.september.web.controller.common.domain.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/kk/manager")
@Api(tags = {"客服名单管理"})
public class ManagerController {

    @Resource
    private KkManagerService managerService;

    /**
     * 获取客服列表（可按状态筛选）
     */
    @GetMapping("/list")
    @ApiOperation("获取客服列表，可按状态筛选")
    public AjaxResult list(@Validated @ModelAttribute ManagerQueryDto queryDto) {
        Integer page = queryDto.getPageNo();
        Integer limit = queryDto.getPageSize();

        // 启用分页
        PageHelper.startPage(page, limit);
        List<KkUser> managers =managerService.getManagerList(queryDto);

        // 分页结果封装
        PageInfo<KkUser> pageInfo = new PageInfo<>(managers);
        PageResult<KkUser> pageResult = PageResult.iPageHandle(
                pageInfo.getTotal(), page.longValue(), limit.longValue(), pageInfo.getList()
        );
        return AjaxResult.success(pageResult);
    }

    /**
     * 新增客服
     */
    @PostMapping("/add")
    @ApiOperation("新增客服")
    public AjaxResult add(@RequestBody KkUser user) {
        managerService.addManager(user);
        return AjaxResult.success("新增成功");
    }

    /**
     * 删除客服
     */
    @PostMapping("/delete")
    @ApiOperation("删除客服")
    public AjaxResult delete(@RequestBody KkUser user) {
        managerService.deleteManager(user.getId());
        return AjaxResult.success("删除成功");
    }

    /**
     * 客服离职（POST 方式）
     */
    @PostMapping("/leave")
    @ApiOperation("客服离职（状态改为离职，角色改为顾客）")
    public AjaxResult leave(@RequestBody KkUser user) {
        managerService.leaveManager(user.getId());
        return AjaxResult.success("离职成功");
    }
}
