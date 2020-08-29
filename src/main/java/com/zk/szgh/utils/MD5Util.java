package com.zk.szgh.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {
    /**
     * 生成md5
     *
     * @param
     * @return
     */
    public static String getMD5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

}


