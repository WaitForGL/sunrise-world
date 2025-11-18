package com.september.sunrise.kk.service.impl;

import com.september.sunrise.kk.dto.HomeIndexDto;
import com.september.sunrise.kk.service.KkHomeIndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class KkHomeIndexServiceImpl implements KkHomeIndexService {

    @Override
    public HomeIndexDto getHomeIndex() {
        HomeIndexDto dto = new HomeIndexDto();

        // 模拟热门订单
        HomeIndexDto.OrderInfo order1 = new HomeIndexDto.OrderInfo();
        order1.setOrderNo("ORD20251118001");
        order1.setPlaymateNickname("陪玩01");
        order1.setGameName("英雄联盟");
        order1.setOrderAmount(new BigDecimal("120"));
        order1.setOrderStatus("已完成");

        HomeIndexDto.OrderInfo order2 = new HomeIndexDto.OrderInfo();
        order2.setOrderNo("ORD20251118002");
        order2.setPlaymateNickname("陪玩02");
        order2.setGameName("王者荣耀");
        order2.setOrderAmount(new BigDecimal("90"));
        order2.setOrderStatus("进行中");

        dto.setHotOrders(Arrays.asList(order1, order2));

        // 模拟热门陪玩
        HomeIndexDto.PlaymateInfo playmate1 = new HomeIndexDto.PlaymateInfo();
        playmate1.setNickname("陪玩01");
        playmate1.setAvatar("https://example.com/avatar01.png");
        playmate1.setGames(Arrays.asList("英雄联盟", "Dota2"));
        playmate1.setAvgPrice(new BigDecimal("100"));

        HomeIndexDto.PlaymateInfo playmate2 = new HomeIndexDto.PlaymateInfo();
        playmate2.setNickname("陪玩02");
        playmate2.setAvatar("https://example.com/avatar02.png");
        playmate2.setGames(Arrays.asList("王者荣耀", "和平精英"));
        playmate2.setAvgPrice(new BigDecimal("90"));

        dto.setHotPlaymates(Arrays.asList(playmate1, playmate2));

        // 模拟热门游戏
        HomeIndexDto.GameInfo game1 = new HomeIndexDto.GameInfo();
        game1.setGameName("英雄联盟");
        game1.setHotDegree(100);
        game1.setAvgPrice(new BigDecimal("120"));

        HomeIndexDto.GameInfo game2 = new HomeIndexDto.GameInfo();
        game2.setGameName("王者荣耀");
        game2.setHotDegree(80);
        game2.setAvgPrice(new BigDecimal("90"));

        dto.setHotGames(Arrays.asList(game1, game2));

        // 模拟活动推荐
        HomeIndexDto.ActivityInfo act1 = new HomeIndexDto.ActivityInfo();
        act1.setTitle("双十一充值优惠");
        act1.setImageUrl("https://example.com/act1.png");
        act1.setDescription("充值满100送20");
        act1.setLink("/activity/1");

        HomeIndexDto.ActivityInfo act2 = new HomeIndexDto.ActivityInfo();
        act2.setTitle("周末陪玩活动");
        act2.setImageUrl("https://example.com/act2.png");
        act2.setDescription("周末陪玩订单打8折");
        act2.setLink("/activity/2");

        dto.setActivities(Arrays.asList(act1, act2));

        return dto;
    }
}
