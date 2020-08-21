package com.zk.szgh.annotation;

import java.lang.annotation.*;

/**
 * @Classname OptionLog
 * @Description TODO 自定义日志注解操作
 * @Date 2020/8/21 9:59 AM
 * @Created by nihui
 * @Version 1.0
 * @Description OptionLog @see support-api
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptionLog {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public String businessType() default "option";

    /**
     * 操作人类别
     */
    public String operatorType() default "admin";

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
