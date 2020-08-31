package com.zk.szgh.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname WechatAccountConfig
 * @Description TODO
 * @Date 2020/8/27 10:32 AM
 * @Created by nihui
 * @Version 1.0
 * @Description WechatAccountConfig @see support-api
 */
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String appid;
    private String appsecret;
    private String msgDataFormat;

    public WechatAccountConfig() {
    }

    public WechatAccountConfig(String appid, String appsecret, String msgDataFormat) {
        this.appid = appid;
        this.appsecret = appsecret;
        this.msgDataFormat = msgDataFormat;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getMsgDataFormat() {
        return msgDataFormat;
    }

    public void setMsgDataFormat(String msgDataFormat) {
        this.msgDataFormat = msgDataFormat;
    }
}
