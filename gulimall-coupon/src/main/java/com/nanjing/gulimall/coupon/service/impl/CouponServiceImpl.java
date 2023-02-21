package com.nanjing.gulimall.coupon.service.impl;

import com.nanjing.common.zhouaop.PringLog;
import com.nanjing.gulimall.coupon.entity.CouponEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanjing.common.utils.PageUtils;
import com.nanjing.common.utils.Query;

import com.nanjing.gulimall.coupon.dao.CouponDao;
import com.nanjing.gulimall.coupon.service.CouponService;


@Service("couponService")
public class CouponServiceImpl extends ServiceImpl<CouponDao, CouponEntity> implements CouponService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CouponEntity> page = this.page(
                new Query<CouponEntity>().getPage(params),
                new QueryWrapper<CouponEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    @PringLog
    public void show(){
        System.out.println("---------");
    }

}