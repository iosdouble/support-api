package com.zk.szgh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Classname SZGHMainApplication
 * @Description TODO
 * @Date 2020/8/20 5:24 PM
 * @Created by nihui
 * @Version 1.0
 * @Description SZGHMainApplication @see support-api
 */
@SpringBootApplication
@EnableSwagger2
public class SZGHMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(SZGHMainApplication.class,args);
    }
}
