package com.atguigu.gulimall.product.entity;

/**
 * @version V1.0
 * @program: gulimail
 * @description: TODO
 * @author: Mr.Zhang
 * @create: 2020-06-02 11:21
 **/

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * 商品三级分类
 *
 * @author ZD
 * @email sunlightcs@gmail.com
 * @date 2020-05-25 14:10:07
 */
@Data
@Table(name = "pms_category")
@Entity
public class JPACategory implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @Id
    private Long catId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父分类id
     */
    private Long parentCid;
    /**
     * 层级
     */
    private Integer catLevel;
    /**
     * 是否显示[0-不显示，1显示]
     */
    private Integer showStatus;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 图标地址
     */
    private String icon;
    /**
     * 计量单位
     */
    private String productUnit;
    /**
     * 商品数量
     */
    private Integer productCount;

    @Transient
    private List<JPACategory> children;

}
