package com.ruoyi.store.utils;

public class DistanceUtils {

    private static final double EARTH_RADIUS = 6371.0; // 地球半径，单位：公里

    // 计算两点间的距离（单位：公里）
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // 将经纬度转换为弧度
        double radLat1 = Math.toRadians(lat1);
        double radLon1 = Math.toRadians(lon1);
        double radLat2 = Math.toRadians(lat2);
        double radLon2 = Math.toRadians(lon2);

        // 计算经纬度差值
        double dLat = radLat2 - radLat1;
        double dLon = radLon2 - radLon1;

        // 使用Haversine公式计算两点间的距离
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(radLat1) * Math.cos(radLat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c; // 返回距离，单位：公里
    }
}
