package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.entity.JPACategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author ZD
 * @email sunlightcs@gmail.com
 * @date 2020-05-25 14:10:07
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<JPACategory> listWithTree();

    void removeMenuByIds(List<Long> asList);

    void updateSort(List<JPACategory> entityList);
}

