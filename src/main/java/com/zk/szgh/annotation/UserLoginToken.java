package com.zk.szgh.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname UserLoginToken
 * @Description TODO
 * @Date 2020/8/21 9:57 AM
 * @Created by nihui
 * @Version 1.0
 * @Description UserLoginToken @see support-api
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginToken {
    boolean required() default true;
}
