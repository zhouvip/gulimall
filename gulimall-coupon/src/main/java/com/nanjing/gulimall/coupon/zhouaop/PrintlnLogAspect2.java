package com.nanjing.gulimall.coupon.zhouaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author yimo
 * @version 1.0
 * @date 2023/2/21 16:43
 */
@Aspect
@Component
public class PrintlnLogAspect2 {

    @Around("@annotation(com.nanjing.gulimall.coupon.zhouaop.PringLog2)")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        System.out.println("log - method around before");
        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("log - method around after.cost time:" + (System.currentTimeMillis() - startTime)+"毫秒");
        return object;
    }
}
