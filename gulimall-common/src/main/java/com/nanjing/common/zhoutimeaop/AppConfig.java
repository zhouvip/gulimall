package com.nanjing.common.zhoutimeaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yimo
 * @version 1.0
 * @date 2023/2/21 17:01
 */
@Configuration
@ComponentScan(basePackages = "com.nanjing.common")
@EnableAspectJAutoProxy
public class AppConfig {
}
