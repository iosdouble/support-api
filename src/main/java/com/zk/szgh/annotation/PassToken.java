package com.zk.szgh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname PassToken
 * @Description TODO
 * @Date 2020/8/21 9:59 AM
 * @Created by nihui
 * @Version 1.0
 * @Description PassToken @see support-api
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
