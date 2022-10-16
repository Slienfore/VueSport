package com.sport.vuesport.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 如果单纯使用 @CrossOrigin 注解的话, 将不能处理 PUT 请求

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 开启跨域请求全局配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 预访问路径
        registry.addMapping("/**").
                // 请求来源
                // 默认为 8080 端口, 如果 8080 端口被占用, 将会 8081、8082 端口, 以此类推
                        allowedOrigins("Http://localhost:8080", "null").
                // 允许的请求方法
                        allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "HEAD").
                // Access-Control-Allow-Credentials 允许携带凭证 => token
                        allowCredentials(true).
                // 准备响应前的缓存持续最大时间(以秒为单位)
                        maxAge(3600);
    }
}