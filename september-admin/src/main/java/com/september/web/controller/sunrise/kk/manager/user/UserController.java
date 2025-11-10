package com.september.web.controller.sunrise.kk.manager.user;

import com.september.sunrise.kk.domain.KkMenu;
import com.september.sunrise.kk.domain.KkUser;
import com.september.sunrise.kk.security.JwtTokenUtil;
import com.september.sunrise.kk.service.KkMenuService;
import com.september.sunrise.kk.service.KkUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kk/manager/user")
@Api(tags = {"用户相关接口"})
public class UserController {

    @Resource
    private KkUserService kkUserService;

    @Resource
    private KkMenuService kkMenuService;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation("获取当前登录用户详情和菜单")
    @GetMapping("/info")
    public Map<String, Object> getUserInfo(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("未登录或Token缺失");
        }

        String token = authHeader.substring(7);
        if (!jwtTokenUtil.validateToken(token)) {
            throw new RuntimeException("Token无效或过期");
        }

        String username = jwtTokenUtil.getUsernameFromToken(token);
        KkUser user = kkUserService.getByUsername(username);
        if (user == null) throw new RuntimeException("用户不存在");

        List<KkMenu> menus = kkMenuService.getMenusByRole(user.getRoleCode());

        Map<String, Object> result = new HashMap<>();
        result.put("user", user);
        result.put("menus", menus);
        return result;
    }
}
