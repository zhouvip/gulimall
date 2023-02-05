package com.nanjing.gulimall.member.dao;

import com.nanjing.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zhouvip
 * @email zhouvip@qq.com
 * @date 2023-02-05 21:34:27
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
