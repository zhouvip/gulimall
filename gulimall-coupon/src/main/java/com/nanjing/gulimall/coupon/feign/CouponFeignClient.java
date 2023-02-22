package com.nanjing.gulimall.coupon.feign;

import com.nanjing.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
/*
* 关于feign接口，是写在服务提供者一端还是，服务消费者一端？
* feign接口可以写在服务提供者一端，也可以写在服务消费者一端，
* 因为启动类的指定了feign接口所在的位置，但是建议写在服务提供者一段，
* 这样feign接口就可以复用，避免重复编写代码。
* 可以写在独立的服务提供者的api服务提供者模块，同样可以代码复用。
*/
@FeignClient(value = "gulimall-coupon", path = "/coupon/coupon", fallback = CouponFeignClientFallback.class)
public interface CouponFeignClient {

    @RequestMapping("/coupon/list")
    public R coupons();

}
