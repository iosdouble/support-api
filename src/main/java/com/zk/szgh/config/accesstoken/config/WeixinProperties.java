package com.zk.szgh.config.accesstoken.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname WeixinProperties
 * @Description TODO
 * @Date 2020/8/14 3:03 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WeixinProperties @see ruoyi
 */
@ConfigurationProperties(prefix = "weixin")
@Component
public class WeixinProperties {
    private String url;
    private String appid;
    private String secret;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
