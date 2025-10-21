package com.september.web.controller.sunrise.kk.wechat;

import com.september.common.core.domain.AjaxResult;
import com.september.sunrise.otherStore.domain.wechat.PayRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kk/pay")
public class WxPayController {

    @PostMapping("/wxPay")
    public AjaxResult wxPay(@RequestBody PayRequest req) {
        return AjaxResult.success();
    }
}
