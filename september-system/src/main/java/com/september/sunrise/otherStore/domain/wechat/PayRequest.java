package com.september.sunrise.otherStore.domain.wechat;

import lombok.Data;

/**
 * 微信公众号支付请求参数
 */
@Data
public class PayRequest {

    /**
     * 商品描述，例如：会员充值、商品购买等
     */
    private String description;

    /**
     * 商户系统内部订单号（需唯一）
     */
    private String orderNo;

    /**
     * 支付金额（单位：分）
     */
    private Integer totalFee;

    /**
     * 用户在公众号中的唯一标识（openid）
     */
    private String openId;

    /**
     * 通知回调地址（可选，默认用系统配置的 notify_url）
     */
    private String notifyUrl;

    /**
     * 币种（默认：CNY）
     */
    private String currency = "CNY";
}
