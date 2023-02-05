package com.nanjing.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nanjing.common.utils.PageUtils;
import com.nanjing.gulimall.ware.entity.PurchaseEntity;

import java.util.Map;

/**
 * 采购信息
 *
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-02-05 21:50:22
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

