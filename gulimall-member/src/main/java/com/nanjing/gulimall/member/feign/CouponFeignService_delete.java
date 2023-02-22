package com.nanjing.gulimall.member.feign;

import com.nanjing.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "gulimall-coupon", path = "/coupon/coupon", fallback = CouponFeignServiceFallback_delete.class)
public interface CouponFeignService_delete {

    @RequestMapping("/member/list")
    public R membercoupons();

}
