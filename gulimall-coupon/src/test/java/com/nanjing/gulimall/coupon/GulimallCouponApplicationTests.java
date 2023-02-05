package com.nanjing.gulimall.coupon;

import com.nanjing.gulimall.coupon.entity.CouponEntity;
import com.nanjing.gulimall.coupon.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallCouponApplicationTests {

    @Autowired
    CouponService couponService;

    @Test
    void contextLoads() {
        CouponEntity coupon = new CouponEntity();
        coupon.setCouponName("优惠券2023");
        couponService.save(coupon);
        System.out.println("保存成功----------");
    }

}
