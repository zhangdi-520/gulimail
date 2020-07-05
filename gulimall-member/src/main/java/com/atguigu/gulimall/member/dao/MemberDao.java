package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ZD
 * @email sunlightcs@gmail.com
 * @date 2020-05-27 17:01:35
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
