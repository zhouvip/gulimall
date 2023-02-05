package com.nanjing.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nanjing.common.utils.PageUtils;
import com.nanjing.gulimall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-02-05 21:50:22
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

