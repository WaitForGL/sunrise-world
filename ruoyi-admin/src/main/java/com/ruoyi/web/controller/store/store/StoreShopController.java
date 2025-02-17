package com.ruoyi.web.controller.store.store;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.store.service.IStoreIndexTypeService;
import com.ruoyi.store.service.IStoreShopService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store/shop")
public class StoreShopController extends BaseController {

    @Resource
    private IStoreShopService service;
}
