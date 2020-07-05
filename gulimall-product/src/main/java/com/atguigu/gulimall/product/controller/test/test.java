package com.atguigu.gulimall.product.controller.test;


import com.atguigu.gulimall.product.service.BrandService;
import com.atguigu.gulimall.product.service.impl.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;

/**
 * @version V1.0
 * @program: gulimail
 * @description: TODO
 * @author: Mr.Zhang
 * @create: 2020-05-25 14:33
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    BrandService brandService;


//    @Autowired
//    OSSClient ossClient;

    @Test
    public void contextLoads() throws FileNotFoundException {
//        InputStream inputStream = new FileInputStream("D:\\tupian\\2.jpg");
//        ossClient.putObject("gulimall-hellozd", "2.jpg", inputStream);
//
//        // 关闭OSSClient。
//        ossClient.shutdown();
//
//        System.out.println("上传完成");
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功");
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("华为荣耀");
//        brandService.updateById(brandEntity);
//        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id",1L));
//        list.forEach((item)->{
//            System.out.println(item);
//        });
        CategoryServiceImpl.say();
    }


}
