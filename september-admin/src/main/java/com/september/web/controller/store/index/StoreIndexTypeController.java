package com.september.web.controller.store.index;

import com.september.common.core.controller.BaseController;
import com.september.common.core.domain.AjaxResult;
import com.september.store.domain.index.vo.StoreIndexTypeVo;
import com.september.store.domain.shop.StoreShop;
import com.september.store.service.IStoreIndexTypeService;
import com.september.store.service.IStoreShopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/store/type")
public class StoreIndexTypeController extends BaseController {

    @Resource
    private IStoreIndexTypeService service;

    @Resource
    private IStoreShopService shopService;


    @GetMapping("/list")
    public AjaxResult list(){
        List<StoreIndexTypeVo> list = service.list();
        return AjaxResult.success("首页分类返回",list);
    }

    @GetMapping("/storeList")
    public AjaxResult StoreListByRange(@RequestParam double latitude, @RequestParam double longitude,@RequestParam double distance){
        List<StoreShop> storeList = shopService.StoreListByRange(latitude, longitude,distance);
        return AjaxResult.success("首页范围内店铺",storeList);
    }





}
