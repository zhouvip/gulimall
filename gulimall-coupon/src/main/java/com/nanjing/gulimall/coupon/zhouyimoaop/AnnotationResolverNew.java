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
 * @date 2023/3/7 15:40
 */
public class AnnotationResolverNew {

    private static AnnotationResolverNew annotationResolver;

    public static AnnotationResolverNew newInstance() {
        if (annotationResolver == null) {
            return annotationResolver = new AnnotationResolverNew();
        } else {
            return annotationResolver;
        }
    }

    /**
     * 解析注解上的值
     */
    public Object resolver(JoinPoint joinPoint, String str) {
        if (str == null) {
            return null;
        }
        Object value = null;
        // 如果name匹配上了#{},则把内容当作变量
        if (str.matches("\\D*#\\{\\D*\\}\\D*")) {
            String newStr = "";
            // pre_#{student.name}_#{student.id}
            String[] split1 = str.split("#\\{");
            for (String valueString : split1) {
                if (valueString.contains("}")) {
                    String[] valueStringSplit = valueString.split("\\}");
                    // 复杂类型
                    if (valueStringSplit[0].contains(".")) {
                        try {
                            newStr = newStr + complexResolver(joinPoint, valueStringSplit[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        newStr = newStr + simpleResolver(joinPoint, valueStringSplit[0]);
                    }
                    if (valueStringSplit.length == 2) {
                        newStr = newStr + valueStringSplit[1];
                    }
                } else {
                    // 拼接的非变量
                    newStr = newStr + valueString;
                }
            }
            value = newStr;
        } else {
            // 非变量
            value = str;
        }
        return value;
    }

    private Object simpleResolver(JoinPoint joinPoint, String str) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parameterNames.length; i++) {
            if (str.equals(parameterNames[i])) {
                return args[i];
            }
        }
        return null;
    }

    private Object complexResolver(JoinPoint joinPoint, String str) throws Exception {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        String[] strs = str.split("\\.");
        for (int i = 0; i < parameterNames.length; i++) {
            if (strs[0].equals(parameterNames[i])) {
                Object obj = args[i];
                Method method = obj.getClass().getDeclaredMethod(getMethodName(strs[1]), null);
                Object value = method.invoke(args[i]);
                return getValue(value, 1, strs);
            }
        }
        return null;
    }

    private Object getValue(Object obj, int index, String[] strs) {
        try {
            if (obj != null && index < strs.length - 1) {
                Method method = obj.getClass().getDeclaredMethod(getMethodName(strs[index + 1]), null);
                obj = method.invoke(obj);
                getValue(obj, index + 1, strs);
            }
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    private String getMethodName(String name) {
        return "get" + name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
    }
}
