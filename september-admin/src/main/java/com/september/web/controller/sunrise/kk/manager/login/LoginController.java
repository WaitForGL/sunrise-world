package com.september.web.controller.sunrise.kk.manager.login;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.dto.LoginRequest;
import com.september.sunrise.kk.dto.LoginResponse;
import com.september.sunrise.kk.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/kk")
@Api(tags = {"后台登录模块"})
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public AjaxResult login(@RequestBody LoginRequest request) {
        LoginResponse resp = loginService.login(request);
        return AjaxResult.success("登录成功", resp);
    }
}