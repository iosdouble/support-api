package com.zk.szgh.config.accesstoken;

import com.zk.szgh.cache.RedisCache;
import com.zk.szgh.config.accesstoken.config.WeixinProperties;
import com.zk.szgh.utils.HttpUtil;
import com.zk.szgh.utils.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Classname WeixinConnnection
 * @Description TODO
 * @Date 2020/8/14 3:17 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WeixinConnnection @see ruoyi
 */
@Component
public class WeixinGetToken {

    private Logger logger = LoggerFactory.getLogger(WeixinGetToken.class);

    private final static String ACCESS_TOKEN = "ACCESS_TOKEN";

    @Autowired
    private WeixinProperties weixinProperties;

    @Autowired
    private RedisCache redisCache;


    public AccessToken getToken() {

        Object access_token = redisCache.getCacheObject("ACCESS_TOKEN");
        if (access_token!=null){
            logger.debug("查询缓存得到的 "+ access_token.toString());
            return (AccessToken) access_token;
        }else {
            logger.debug("查询接口");
            System.out.println(weixinProperties.getUrl());
            Map params = new HashMap<>();
            params.put("grant_type","client_credential");
            params.put("appid",weixinProperties.getAppid());
            params.put("secret",weixinProperties.getSecret());
            String doGet = HttpUtil.doGet(weixinProperties.getUrl(),params);
            System.out.println(doGet);
            AccessToken accessToken = JsonUtil.toObject(doGet, AccessToken.class);
            System.out.println(accessToken);
            if (accessToken != null) {
                redisCache.setCacheObject(ACCESS_TOKEN,accessToken,accessToken.getExpires_in(),TimeUnit.SECONDS);
                return accessToken;
            } else {
                accessToken = null;
                // 获取token失败
                logger.error("jsonObject为空，获取token失败");
            }
            return accessToken;
        }
    }
}
