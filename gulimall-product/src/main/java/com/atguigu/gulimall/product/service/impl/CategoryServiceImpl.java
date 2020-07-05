package com.atguigu.gulimall.product.service.impl;

import com.atguigu.common.utils.Copy;
import com.atguigu.gulimall.product.entity.JPACategory;
import com.atguigu.gulimall.product.repository.JPACategoryRepository;
import com.atguigu.gulimall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    JPACategoryRepository jpaCategoryRepository;

    @Autowired
    BrandService brandService;

    private static CategoryServiceImpl brandServiceImpl;

    @PostConstruct
    public void init(){
        brandServiceImpl = this;
        brandServiceImpl.brandService = this.brandService;
    }

    public static void say(){
        brandServiceImpl.brandService.say();
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<JPACategory> listWithTree() {
        List<JPACategory> jpaCategoryList = jpaCategoryRepository.findAllByShowStatus(1);

        List<JPACategory> level1Menus = jpaCategoryList.stream().filter(jpaCategory ->
                jpaCategory.getParentCid() == 0
        ).map((menu)->{
            menu.setChildren(getChildrens(menu,jpaCategoryList));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return level1Menus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO
        jpaCategoryRepository.deleteByAsList(asList);
    }

    @Transactional
    @Override
    public void updateSort(List<JPACategory> entityList) {
        List<Long> ids = entityList.stream().map(jpaCategory -> jpaCategory.getCatId()).collect(Collectors.toList());
        List<JPACategory> jpaCategoryList = jpaCategoryRepository.findByCatIdIn(ids);
        for (JPACategory j:jpaCategoryList) {
            for(JPACategory jpaCategory:entityList){
                if(j.getCatId()==jpaCategory.getCatId()){
                    Copy.mergeObject(jpaCategory,j);
                }
            }

        }
        jpaCategoryRepository.saveAll(jpaCategoryList);
    }
    private List<JPACategory> getChildrens(JPACategory root ,List<JPACategory> all){
        List<JPACategory> children = all.stream().filter(jpaCategory -> {
            return jpaCategory.getParentCid() == root.getCatId();
        }).map(jpaCategory -> {
            jpaCategory.setChildren(getChildrens(jpaCategory, all));
            return jpaCategory;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return children;
    }

}