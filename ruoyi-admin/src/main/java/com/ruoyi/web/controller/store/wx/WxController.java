package com.ruoyi.web.controller.store.wx;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.store.domain.user.StoreUser;
import com.ruoyi.store.service.IStoreIndexTypeService;
import com.ruoyi.store.service.IStoreUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store/wx")
public class WxController extends BaseController {

    @Resource
    private IStoreUserService userService;

    /**
     * 微信登录
     * @param code
     * @return
     */
    @PostMapping("/wxLogin")
    public AjaxResult wxLogin(String code){
        String appid="wxd3e18ab52464b10c";
        String secret="001525f10908f042ef075316c979af12";
        String jsCode=code;

        String url = String.format(
                "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code",
                appid, secret, jsCode
        );
        // 发送 GET 请求并获取响应openid和session_key
        String response = HttpRequest.get(url)
                .timeout(5000)  // 设置超时时间
                .execute()
                .body();
//        存入redis
//        WXSessionModel wxSessionModel= JSON.parseObject(wxResult,WXSessionModel.class);
//        redisService.set("user-redis-session: "+wxSessionModel.getOpenid(),wxSessionModel.getSession_key());
        // 解析 JSON 数据
        JSONObject jsonResponse = new JSONObject(response);
        //校验openid是否存在
        String openId = jsonResponse.getJSONObject("data").getStr("openid");
        StoreUser storeUser = userService.selectByOpenid(openId);
        //如果用户不存在数据库
        if(ObjectUtil.isNull(storeUser)){
            userService.insertUserOpenId(openId);
            return AjaxResult.error("用户不存在");
        }else {

            return AjaxResult.success(jsonResponse);
        }

    }


    /**
     * 获取用户手机号
     * @param code
     * @return
     */
    @PostMapping("/getPhoneNumber")
    public AjaxResult getPhoneNumber(String code){
        String appid="wxd3e18ab52464b10c";
        String secret="001525f10908f042ef075316c979af12";
        // 构造请求 URL
        String url = String.format(
                "https://api.weixin.qq.com/cgi-bin/token?appid=%s&secret=%s&grant_type=client_credential",
                appid, secret
        );
        // 发送 GET 请求并获取响应
        String response = HttpRequest.get(url)
                .timeout(5000)  // 设置超时时间
                .execute()
                .body();
        // 解析 JSON 数据
        JSONObject jsonResponse = new JSONObject(response);
        System.out.println(jsonResponse);

        String newToken = jsonResponse.getStr("access_token");

        // 构造请求 URL
        String newUrl = String.format(
                "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=%s",
                newToken
        );

        // 构造请求参数
        JSONObject requestBody = new JSONObject();
        requestBody.put("code", code);

        // 发送 POST 请求并获取响应
        String phoneResponse = HttpRequest.post(newUrl)
                .timeout(5000)  // 设置超时时间
                .header("Content-Type", "application/json")  // 设置请求头
                .body(requestBody.toString())  // 设置请求体
                .execute()
                .body();

        return AjaxResult.success("返回手机号",phoneResponse);
    }

}
