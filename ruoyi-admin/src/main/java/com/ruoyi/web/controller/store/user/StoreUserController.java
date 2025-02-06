package com.ruoyi.web.controller.store.user;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.store.domain.user.request.IndexCountRequest;
import com.ruoyi.store.domain.user.response.IndexCountVo;
import com.ruoyi.store.service.IStoreUserService;
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
