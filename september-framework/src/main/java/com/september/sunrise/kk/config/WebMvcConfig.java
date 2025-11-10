package com.september.sunrise.kk.config;

import com.september.sunrise.kk.security.JwtAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JwtAuthInterceptor jwtAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截 /kk/manager/** 路径，排除登录接口
        registry.addInterceptor(jwtAuthInterceptor)
                .addPathPatterns("/kk/manager/**")
                .excludePathPatterns("/kk/manager/auth/login");
    }
}
