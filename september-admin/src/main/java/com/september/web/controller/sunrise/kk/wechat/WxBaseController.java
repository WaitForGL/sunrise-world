package com.september.web.controller.sunrise.kk.wechat;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.JSONObject;
import com.september.common.core.controller.BaseController;
import com.september.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kk/wx")
public class WxBaseController extends BaseController {


    private static final String APPID = "wxbbb06c708f73c252";
    private static final String APPSECRET = "6d5c1efca6bb18eefd7a1779d2ef2cc0";

    /**
     * 获取微信接口调用凭据（access_token）
     */
    @GetMapping("/getAccessToken")
    public AjaxResult getAccessToken() {
        try {
            String url = String.format(
                    "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",
                    APPID, APPSECRET);

            // 使用 Hutool 发送 GET 请求
            String response = HttpUtil.get(url);

            // 解析 JSON 返回结果
            JSONObject json = JSONUtil.parseObj(response);
            if (json.containsKey("access_token")) {
                String accessToken = json.getStr("access_token");
                int expiresIn = json.getInt("expires_in", 7200);
                return AjaxResult.success("获取成功",
                        JSONUtil.createObj()
                                .set("access_token", accessToken)
                                .set("expires_in", expiresIn)
                );
            } else {
                // 微信返回错误信息
                return AjaxResult.error("获取失败：" + json.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("调用接口异常：" + e.getMessage());
        }
    }


    /**
     * 回调接口，通过code换取openid
     */
    @GetMapping("/wechat/callback")
    public AjaxResult getOpenId(@RequestParam("code") String code) {
        try {
            // 1. 拼接请求URL
            String url = String.format(
                    "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",
                    APPID, APPSECRET, code);

            // 2. 发送GET请求
            String response = HttpUtil.get(url);
            JSONObject json = JSONUtil.parseObj(response);

            // 3. 判断是否成功
            if (json.containsKey("openid")) {
                String openid = json.getStr("openid");
                return AjaxResult.success("获取成功", json);
            } else {
                return AjaxResult.error("获取失败：" + json.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("接口调用异常：" + e.getMessage());
        }
    }



}
