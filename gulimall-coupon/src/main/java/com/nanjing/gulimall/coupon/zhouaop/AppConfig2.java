package com.nanjing.gulimall.coupon.zhouaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yimo
 * @version 1.0
 * @date 2023/2/21 17:01
 * https://blog.51cto.com/u_15060508/4372039
 * springboot在公共模块自定义注解，在其他微服务使用时无法生效问题
 */
@Configuration
@ComponentScan(basePackages = "com.nanjing")
@EnableAspectJAutoProxy
public class AppConfig2 {
}
