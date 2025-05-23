package com.september.web.controller.sunrise.login;

import com.september.common.constant.Constants;
import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.domain.login.request.SrUserLoginRequest;
import com.september.sunrise.domain.register.request.SrUserRegisterRequest;
import com.september.sunrise.service.SrLoginService;
import com.september.sunrise.service.SrRegisterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 注册登录相关
 *
 * @author september
 */
@RestController
@RequestMapping("/sunrise")
public class SrLoginController {

    @Resource
    SrRegisterService registerService;

    @Resource
    SrLoginService loginService;

    /**
     * 注册功能
     * @param registerVo
     * @return
     */
    @PostMapping("/register")
    public AjaxResult register(@RequestBody SrUserRegisterRequest registerVo){
        registerService.register(registerVo);
        return AjaxResult.success("注册成功");
    }


    /**
     * 登录功能
     * @param loginVo
     * @return
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody SrUserLoginRequest loginVo){
        AjaxResult ajax = AjaxResult.success();
        String token = loginService.login(loginVo);
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
}
