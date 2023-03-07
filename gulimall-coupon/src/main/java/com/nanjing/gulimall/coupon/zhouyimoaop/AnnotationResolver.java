package com.nanjing.gulimall.coupon.zhouyimoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author yimo
 * @version 1.0
 * @date 2023/3/7 13:50
 * 注解解析工具类
 */
public class AnnotationResolver {

    private static AnnotationResolver annotationResolver;

    public static AnnotationResolver newInstance() {
        if (annotationResolver == null) {
            return annotationResolver = new AnnotationResolver();
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
        if (str.matches("#\\{\\D*\\}")) {
            String newStr = str.replaceAll("#\\{", "").replaceAll("\\}", "");
            // 复杂类型
            if (newStr.contains(".")) {
                try {
                    value = complexResolver(joinPoint, newStr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                value = simpleResolver(joinPoint, newStr);
            }
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
                // str[1] 方法名
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
