package com.nanjing.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import com.nanjing.common.utils.PageUtils;
import com.nanjing.common.utils.R;
import com.nanjing.common.zhoushuaop.BusinessType;
import com.nanjing.common.zhoushuaop.Log;
import com.nanjing.gulimall.coupon.entity.CouponEntity;
import com.nanjing.gulimall.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 优惠券信息
 *
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-02-05 20:53:04
 */
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;


    @RequestMapping("/coupon/list")
    @Log(title = "查询优惠券信息", businessType = BusinessType.OTHER)
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
    }

    //--------------------------------------------------------------------------------

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
