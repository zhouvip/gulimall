package com.nanjing.gulimall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nanjing.gulimall.product.entity.AttrEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 * 
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-02-05 10:43:23
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {
	
}
