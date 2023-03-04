package com.nanjing.gulimall.coupon.zhouyimoaop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yimo
 * @version 1.0
 * @date 2023/3/4 17:18
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAspectAnnotation {

    String name() default "name";

    String key() default "key";

    String id() default "0";

}
