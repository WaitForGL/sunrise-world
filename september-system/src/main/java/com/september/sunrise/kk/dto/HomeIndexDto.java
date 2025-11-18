package com.september.sunrise.kk.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("首页数据DTO")
public class HomeIndexDto {

    @ApiModelProperty("热门订单列表")
    private List<OrderInfo> hotOrders;

    @ApiModelProperty("热门陪玩列表")
    private List<PlaymateInfo> hotPlaymates;

    @ApiModelProperty("热门游戏列表")
    private List<GameInfo> hotGames;

    @ApiModelProperty("活动推荐列表")
    private List<ActivityInfo> activities;

    @Data
    @ApiModel("热门订单信息")
    public static class OrderInfo {
        private String orderNo;
        private String playmateNickname;
        private String gameName;
        private BigDecimal orderAmount;
        private String orderStatus;
    }

    @Data
    @ApiModel("热门陪玩信息")
    public static class PlaymateInfo {
        private String nickname;
        private String avatar;
        private List<String> games; // 擅长游戏名称
        private BigDecimal avgPrice;
    }

    @Data
    @ApiModel("热门游戏信息")
    public static class GameInfo {
        private String gameName;
        private Integer hotDegree;
        private BigDecimal avgPrice;
    }

    @Data
    @ApiModel("活动推荐信息")
    public static class ActivityInfo {
        private String title;
        private String imageUrl;
        private String description;
        private String link;
    }
}
