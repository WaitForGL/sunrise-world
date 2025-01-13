package com.ruoyi.web.controller.store.index;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.store.domain.index.vo.StoreIndexTypeVo;
import com.ruoyi.store.service.IStoreIndexTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/store/type")
public class StoreIndexTypeController extends BaseController {

    @Resource
    private IStoreIndexTypeService service;

    @GetMapping("/list")
    public AjaxResult list(){
        List<StoreIndexTypeVo> list = service.list();
        return AjaxResult.success("首页分类返回",list);
    }

}
