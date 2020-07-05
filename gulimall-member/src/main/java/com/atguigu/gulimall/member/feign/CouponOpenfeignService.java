package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: gulimail
 * @description: 微服务接口调用
 * @author: Mr.Wang
 * @create: 2020-05-29 08:51
 **/

@FeignClient("gulimall-coupon")
public interface CouponOpenfeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
