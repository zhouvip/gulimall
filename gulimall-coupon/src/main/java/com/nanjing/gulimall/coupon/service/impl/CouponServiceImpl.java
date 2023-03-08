package com.nanjing.gulimall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanjing.common.utils.PageUtils;
import com.nanjing.common.utils.Query;
import com.nanjing.common.zhouaop.PringLog;
import com.nanjing.common.zhoushuaop.BusinessType;
import com.nanjing.common.zhoushuaop.Log;
import com.nanjing.gulimall.coupon.dao.CouponDao;
import com.nanjing.gulimall.coupon.entity.CouponEntity;
import com.nanjing.gulimall.coupon.service.CouponService;
import com.nanjing.gulimall.coupon.zhouyimoaop.MyAspectAnnotation;
import com.nanjing.gulimall.coupon.zhouyimoaop.Student;
import org.springframework.stereotype.Service;

import java.util.Map;


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

    @Override
    @MyAspectAnnotation(name = "张三", key = "key1", id = "111")
    public void show2(){
        System.out.println("---------");
    }

    @Override
    //@MyAspectAnnotation(name = "#{student.name}", key = "#{key}", id = "#{student.id}")
    @MyAspectAnnotation(name = "pre_#{student.name}_#{student.id}_#{key}", key = "#{key}", id = "#{student.id}")
    public void doSomeThing(String key, Student student){
        System.out.println("doSomeThing..........................");
    }



}