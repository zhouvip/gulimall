package com.nanjing.gulimall.member.controller;

import com.nanjing.common.utils.R;
import com.nanjing.gulimall.coupon.api.feign.CouponFeignClient;
import com.nanjing.gulimall.member.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 会员
 *
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-02-05 21:34:27
 */
@RestController
@RequestMapping("v1/feign")
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        R membercoupons = couponFeignClient.coupons();
        return R.ok().put("member", memberEntity).put("coupons",membercoupons.get("coupons"));
    }






}
