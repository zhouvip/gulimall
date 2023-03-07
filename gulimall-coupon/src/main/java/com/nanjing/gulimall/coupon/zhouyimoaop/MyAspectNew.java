package com.nanjing.gulimall.coupon.zhouyimoaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author yimo
 * @version 1.0
 * @date 2023/3/7 14:05
 */
@Aspect
@Component
@Slf4j
public class MyAspectNew {

    @Around(value = "@annotation(myAspectAnnotation)", argNames = "joinPoint,myAspectAnnotation")
    public Object doAround(ProceedingJoinPoint joinPoint, MyAspectAnnotation myAspectAnnotation) throws Throwable {
        log.info("进入环绕切面...................");
        String name = (String) AnnotationResolverNew.newInstance().resolver(joinPoint, myAspectAnnotation.name());
        String key = (String) AnnotationResolverNew.newInstance().resolver(joinPoint, myAspectAnnotation.key());
        //Integer id = (Integer) AnnotationResolverNew.newInstance().resolver(joinPoint, myAspectAnnotation.id()); 转换异常，改成String
        String id = (String) AnnotationResolverNew.newInstance().resolver(joinPoint, myAspectAnnotation.id());
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
        String name = (String) AnnotationResolverNew.newInstance().resolver(joinPoint, myAspectAnnotation.name());
        log.info("name...................{}", name);
    }

    @After(value = "@annotation(myAspectAnnotation)", argNames = "joinPoint,myAspectAnnotation")
    public void afterLog(JoinPoint joinPoint, MyAspectAnnotation myAspectAnnotation){
        log.info("进入方法执行后切面...................");
        String name = (String) AnnotationResolverNew.newInstance().resolver(joinPoint, myAspectAnnotation.name());
        log.info("name...................{}", name);
    }

}