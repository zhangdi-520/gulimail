package com.atguigu.common.utils;

import java.lang.reflect.Field;

/**
 * @version V1.0
 * @program: gulimail
 * @description: TODO
 * @author: Mr.Zhang
 * @create: 2020-06-28 20:40
 **/
public class Copy {

    public static <T>  void mergeObject(T origin, T destination) {
        if (origin == null || destination == null)
            return;
        if (!origin.getClass().equals(destination.getClass()))
            return;

        Field[] fields = origin.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            try {
                fields[i].setAccessible(true);
                Object value = fields[i].get(origin);
                if (null != value) {
                    fields[i].set(destination, value);
                }
                fields[i].setAccessible(false);
            } catch (Exception e) {
            }
        }
    }
}
