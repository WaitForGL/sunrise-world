package com.ruoyi.store.domain.shop;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class StoreShop {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 商铺标题
     */
    private String shopTitle;

    /**
     * 商铺图片
     */
    private String shopPhoto;

    /**
     * 店铺类型（0 租 1 转）
     */
    private String shopType;

    /**
     * 是否热门（0否 1 是）
     */
    private Integer isHot;

    /**
     * 商铺价格
     */
    private BigDecimal shopPrice;

    /**
     * 商铺面积
     */
    private String shopArea;

    /**
     * 商品所属人
     */
    private Long shopOwner;

    /**
     * 店铺所属行政区
     */
    private String shopDistrict;

    /**
     * 店铺纬度
     */
    private Double shopLat;

    /**
     * 店铺经度
     */
    private Double shopLon;

    /**
     * 店铺展示级别
     */
    private Integer shopLever;

    /**
     * 店铺展示级别
     */
    private Date addTime;
}
