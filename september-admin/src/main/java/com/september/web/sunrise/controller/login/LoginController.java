package com.september.web.sunrise.controller.login;

import cn.dev33.satoken.stp.StpUtil;
import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.until.StringUtils;
import com.september.sunrise.entity.user.User;
import com.september.web.sunrise.service.user.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manage/login")
public class LoginController {

    @Resource
    private IUserService userService;

    /**
     * 注册 登录
     * 用户存在即登录 用户不存在即注册登录
     */
    @GetMapping("/passwordLogin")
    public AjaxResult passwordLogin(String username,String password){
        User user = userService.isExistUser(username,password);
        if(StringUtils.isNotNull(user)){
            StpUtil.login(user.getId());
            return AjaxResult.success("login success",user);
        }else{
            userService.insertUser(username,password);
            User newUser = userService.isExistUser(username,password);
            StpUtil.login(newUser.getId());
            return AjaxResult.success("login success",newUser);
        }
    }

    
    
    
}
