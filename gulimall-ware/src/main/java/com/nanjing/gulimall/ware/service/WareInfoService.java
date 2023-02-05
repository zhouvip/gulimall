package com.nanjing.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nanjing.common.utils.PageUtils;
import com.nanjing.gulimall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-02-05 21:50:22
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

