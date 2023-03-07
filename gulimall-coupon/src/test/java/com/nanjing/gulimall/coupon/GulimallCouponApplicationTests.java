package com.nanjing.gulimall.coupon;

import com.nanjing.common.zhouaop.AppConfig;
import com.nanjing.common.zhouaop.Car;
import com.nanjing.gulimall.coupon.entity.CouponEntity;
import com.nanjing.gulimall.coupon.service.CouponService;
import com.nanjing.gulimall.coupon.zhouyimoaop.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class GulimallCouponApplicationTests {

    @Autowired
    CouponService couponService;

    @Test
    void contextLoads() {
        CouponEntity coupon = new CouponEntity();
        coupon.setCouponName("优惠券2023");
        //couponService.save(coupon);
        //couponService.show();
        //couponService.show2();
        System.out.println("保存成功----------");
    }

    @Test
    void testAop() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = context.getBean("car", Car.class);
        car.show();
        System.out.println("自定义注解----------");
    }


    @Test
    void testStudent() {
        String key = "key1111";
        Student student = new Student();
        student.setId(10);
        student.setName("刘德华");
        couponService.doSomeThing(key,student);
        System.out.println("成功----------");
    }


}
