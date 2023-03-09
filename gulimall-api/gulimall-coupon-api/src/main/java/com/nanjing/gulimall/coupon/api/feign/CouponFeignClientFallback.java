package com.nanjing.gulimall.coupon.api.feign;

import com.nanjing.common.utils.R;
import org.springframework.stereotype.Component;

/**
 * @author yimo
 * @version 1.0
 * @date 2023/2/22 11:56
 * 容错类主要是在调用对应的服务接口时如果出现异常时的应急措施，返回一个自定义结果
 */
@Component
public class CouponFeignClientFallback implements CouponFeignClient{
    @Override
    public R coupons() {
        return R.error("服务不可用");
    }
}
