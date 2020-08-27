package com.zk.szgh.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zk.szgh.cache.RedisCache;
import com.zk.szgh.dao.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname TokenService
 * @Description TODO
 * @Date 2020/8/21 10:28 AM
 * @Created by nihui
 * @Version 1.0
 * @Description TokenService @see support-api
 */
@Service
public class TokenService {
//    // 令牌自定义标识
//    @Value("${token.header}")
//    private String header;
//
//    // 令牌秘钥
//    @Value("${token.secret}")
//    private String secret;
//
//    // 令牌有效期（默认30分钟）
//    @Value("${token.expireTime}")
//    private int expireTime;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;


    @Autowired
    private RedisCache redisCache;


    public String getToken(SysUser user) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getUserId()))// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }


}
