package com.nanjing.gulimall.order.dao;

import com.nanjing.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-02-05 21:19:47
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
