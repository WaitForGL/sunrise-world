package com.september.web.controller.store.user;

import com.september.common.core.controller.BaseController;
import com.september.common.core.domain.AjaxResult;
import com.september.store.domain.user.StoreUser;
import com.september.store.domain.user.request.IndexCountRequest;
import com.september.store.domain.user.response.IndexCountVo;
import com.september.store.service.IStoreUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store/user")
public class StoreUserController extends BaseController {

    @Resource
    private IStoreUserService userService;


    /**
     * 查询用户基本信息
     * @param openId
     * @return
     */
    @PostMapping("/userInfo")
    public AjaxResult userInfo(String openId){
        StoreUser storeUser = userService.selectByOpenid(openId);
        return AjaxResult.success("用户基本信息返回",storeUser);
    }

    /**
     * 首页关注 收集 足迹
     * @param request
     * @return
     */
    @PostMapping("/userIndex")
    public AjaxResult userIndex(@RequestBody IndexCountRequest request){
        IndexCountVo indexCountVo = userService.userIndex(request);
        return AjaxResult.success("首页关注 收集 足迹数量返回",indexCountVo);
    }


}
