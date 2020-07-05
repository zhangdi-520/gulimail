package com.atguigu.gulimall.ware.dao;

import com.atguigu.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author ZD
 * @email sunlightcs@gmail.com
 * @date 2020-05-25 15:18:51
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
