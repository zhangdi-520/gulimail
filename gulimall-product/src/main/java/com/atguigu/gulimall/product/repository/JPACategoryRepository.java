package com.atguigu.gulimall.product.repository;

import com.atguigu.gulimall.product.entity.JPACategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.util.List;

/**
 * @program: gulimail
 * @description: JPA工厂
 * @author: Mr.Wang
 * @create: 2020-06-03 15:34
 **/
public interface JPACategoryRepository extends JpaRepository<JPACategory,Long>, QuerydslPredicateExecutor<JPACategory> {


    @Modifying
    @Transactional
    @Query(value = "update JPACategory J set J.showStatus = 0 where J.catId in ?1")
    void deleteByAsList(List<Long> asList);


    List<JPACategory> findAllByShowStatus(Integer status);

    List<JPACategory> findByCatIdIn(List<Long> ids);
}
