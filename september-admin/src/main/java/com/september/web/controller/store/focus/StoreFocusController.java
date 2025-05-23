package com.september.web.controller.store.focus;

import com.september.common.core.controller.BaseController;
import com.september.common.core.domain.AjaxResult;
import com.september.store.domain.focus.request.MyFocusRequest;
import com.september.store.domain.focus.response.StoreFocusResponse;
import com.september.store.service.IStoreFocusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 获取首页个人关注店铺的点
 */
@RestController
@RequestMapping("/store/focus")
public class StoreFocusController extends BaseController {

    @Resource
    private IStoreFocusService service;

    @PostMapping("/myFocus")
    public AjaxResult myFocus(@RequestBody MyFocusRequest request){
        List<StoreFocusResponse> list = service.myFocus(request);
        return AjaxResult.success("首页分类返回",list);
    }
}
