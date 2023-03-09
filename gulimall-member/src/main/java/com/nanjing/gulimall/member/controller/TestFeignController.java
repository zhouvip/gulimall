package com.nanjing.gulimall.member.controller;

import com.nanjing.common.utils.PageUtils;
import com.nanjing.common.utils.R;
import com.nanjing.gulimall.coupon.entity.CouponEntity;
import com.nanjing.gulimall.coupon.feign.CouponFeignClient;
import com.nanjing.gulimall.member.entity.MemberEntity;
import com.nanjing.gulimall.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 会员
 *
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-02-05 21:34:27
 */
@RestController
@RequestMapping("feign/member")
public class TestFeignController {


    @Autowired
    CouponFeignClient couponFeignClient;

    /*
     * @filename: MemberController.java
     * @author: yimo
     * @date: 2023/2/22 13:50
     * @description: 测试feign调用
     **/
    @RequestMapping("/coupons")
    public R test(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("花无缺");
        R membercoupons = couponFeignClient.coupons();
        return R.ok().put("member", memberEntity).put("coupons",membercoupons.get("coupons"));
    }


    /*@RequestMapping("/coupon/list")
    public R coupons(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减50");
        //测试模拟feign调用超时
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return R.ok().put("coupons", Arrays.asList(couponEntity));
    }*/



}
