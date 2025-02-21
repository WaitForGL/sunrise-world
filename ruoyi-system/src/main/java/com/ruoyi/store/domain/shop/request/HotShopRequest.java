package com.ruoyi.store.domain.shop.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HotShopRequest {

    /**
     * 商铺关键字
     */
    private String shopTitle;

    /**
     * 商铺面积范围最小值
     */
    private Integer shopAreaMin;
    /**
     * 商铺面积范围最大值
     */
    private Integer shopAreaMax;

    /**
     * 商铺价格最小值
     */
    private BigDecimal shopPriceMin;

    /**
     * 商铺价格最大值
     */
    private BigDecimal shopPriceMax;

    /**
     * 店铺所属行政区
     */
    private String shopDistrict;
}
