package com.ruoyi.web.controller.store.index;

import com.ruoyi.common.core.controller.BaseController;

import com.ruoyi.store.service.IStoreIndexTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store/type")
public class StoreIndexTypeController extends BaseController {

    @Resource
    private IStoreIndexTypeService service;
}
