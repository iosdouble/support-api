package com.zk.szgh.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Classname SecurityUtils
 * @Description TODO
 * @Date 2020/8/21 4:44 PM
 * @Created by nihui
 * @Version 1.0
 * @Description SecurityUtils @see support-api
 */
public class SecurityUtils {

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
