package com.nanjing.gulimall.coupon.api.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yimo
 * @version 1.0
 * @date 2023/2/22 15:22
 */
@Configuration
public class FeignConfig {
    /**
     * feignClient配置日志级别
     * Feign的日志级别有:
     * NONE：默认的，不显示任何日志；
     * BASIC：仅记录请求方法、URL、响应状态码及执行时间；
     * HEADERS：除了 BASIC 中定义的信息之外，还有请求和响应的头信息；
     * FULL：除了 HEADERS 中定义的信息之外，还有请求和响应的正文及元数据。
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        //请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }

}
