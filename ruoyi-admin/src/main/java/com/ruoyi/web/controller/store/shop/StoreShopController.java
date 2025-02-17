package com.ruoyi.web.controller.store.shop;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.store.domain.shop.StoreShop;
import com.ruoyi.store.domain.shop.request.HotShopRequest;
import com.ruoyi.store.service.IStoreShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/store/shop")
public class StoreShopController extends BaseController {

    @Resource
    private IStoreShopService service;

    @GetMapping("/isHot")
    public AjaxResult isHot(HotShopRequest request){
        List<StoreShop> list = service.isHot(request);
        return AjaxResult.success("店铺首页热门推荐",list);
    }
}
