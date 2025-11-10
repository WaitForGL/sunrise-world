package com.september.web.controller.sunrise.kk.manager.auth;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.dto.LoginRequest;
import com.september.sunrise.kk.security.JwtTokenUtil;
import com.september.sunrise.kk.service.KkUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/kk/manager/auth")
@Api(tags = {"后台登录模块"})
public class AuthController {

    @Resource
    private KkUserService kkUserService;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        KkUser user = kkUserService.getByUsername(username);
        if (user == null) {
            return AjaxResult.error("用户名不存在");
        }
        if (user.getIsDelete() != null && user.getIsDelete() == 1) {
            return AjaxResult.error("用户已被删除");
        }
        if (user.getStatus() == null || user.getStatus() != 1) {
            return AjaxResult.error("用户状态异常，无法登录");
        }
        if (!password.equals(user.getPassword())) {
            return AjaxResult.error("用户名或密码错误");
        }

        String token = jwtTokenUtil.generateToken(username);
        Map<String, Object> result = new HashMap<>();
        result.put("token", token);

        return AjaxResult.success(result);
    }
}
