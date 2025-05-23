package com.september.web.controller.system;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.september.common.core.controller.BaseController;
import com.september.common.core.domain.AjaxResult;
import com.september.common.core.domain.model.RegisterBody;
import com.september.common.utils.StringUtils;
import com.september.framework.web.service.SysRegisterService;
import com.september.system.service.ISysConfigService;

/**
 * 注册验证
 * 
 * @author september
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Resource
    private SysRegisterService registerService;

    @Resource
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
