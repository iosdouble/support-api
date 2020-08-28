package com.zk.szgh.config;

import com.zk.szgh.config.properties.WechatAccountConfig;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Classname WeChatMpConfig
 * @Description TODO
 * @Date 2020/8/27 10:33 AM
 * @Created by nihui
 * @Version 1.0
 * @Description WeChatMpConfig @see support-api
 */
@Configuration
public class WeChatMpConfig {

    @Autowired
    private WechatAccountConfig accountConfig;

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpDefaultConfigImpl wxMpDefaultConfig = new WxMpDefaultConfigImpl();
        wxMpDefaultConfig.setAppId(accountConfig.getAppid());
        wxMpDefaultConfig.setSecret(accountConfig.getAppsecret());
        return wxMpDefaultConfig;
    }
}
