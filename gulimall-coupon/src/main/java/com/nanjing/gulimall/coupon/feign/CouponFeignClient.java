package com.nanjing.gulimall.coupon.feign;

import com.nanjing.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "gulimall-coupon", path = "/coupon/coupon", fallback = CouponFeignClientFallback.class)
public interface CouponFeignClient {

    @RequestMapping("/coupon/list")
    public R coupons();

}
