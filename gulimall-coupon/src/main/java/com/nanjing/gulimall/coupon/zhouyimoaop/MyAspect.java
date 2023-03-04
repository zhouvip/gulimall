package com.nanjing.gulimall.coupon.zhouyimoaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author yimo
 * @version 1.0
 * @date 2023/3/4 17:20
 * https://zhuanlan.zhihu.com/p/538132473
 */
@Aspect
@Component
@Slf4j
public class MyAspect {
    @Around(value = "@annotation(myAspectAnnotation)", argNames = "joinPoint,myAspectAnnotation")
    public Object doAround(ProceedingJoinPoint joinPoint, MyAspectAnnotation myAspectAnnotation) throws Throwable {
        log.info("进入环绕切面...................");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String name = myAspectAnnotation.name();
        String key = myAspectAnnotation.key();
        Integer id =  Integer.parseInt(myAspectAnnotation.id());
        log.info("name...................{}", name);
        log.info("key...................{}", key);
        log.info("id...................{}", id);
        try {
            log.info("环绕前...................");
            return joinPoint.proceed();
        } finally {
            log.info("环绕后...................");
        }
    }

    @Before(value = "@annotation(myAspectAnnotation)", argNames = "joinPoint,myAspectAnnotation")
    public void beforeLog(JoinPoint joinPoint, MyAspectAnnotation myAspectAnnotation){
        log.info("进入方法执行前切面...................");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String name = myAspectAnnotation.name();
        log.info("name...................{}", name);
    }

    @After(value = "@annotation(myAspectAnnotation)", argNames = "joinPoint,myAspectAnnotation")
    public void afterLog(JoinPoint joinPoint, MyAspectAnnotation myAspectAnnotation){
        log.info("进入方法执行后切面...................");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String name = myAspectAnnotation.name();
        log.info("name...................{}", name);
    }
}
