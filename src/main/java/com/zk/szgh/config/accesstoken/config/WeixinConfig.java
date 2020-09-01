package com.zk.szgh.config.accesstoken.config;

import me.chanjar.weixin.mp.api.WxMpCardService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpCardServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname WeixinConfig
 * @Description TODO
 * @Date 2020/8/14 3:12 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WeixinConfig @see ruoyi
 */
@Configuration
public class WeixinConfig {

    @Autowired
    private WeixinProperties weixinProperties;

    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpDefaultConfigImpl wxMpDefaultConfig = new WxMpDefaultConfigImpl();
        wxMpDefaultConfig.setAppId(weixinProperties.getAppid());
        wxMpDefaultConfig.setSecret(weixinProperties.getSecret());
        return wxMpDefaultConfig;
    }
    @Bean
    public WxMpCardService wxMpCardService(){
        WxMpCardService wxMpCardService = new WxMpCardServiceImpl(wxMpService());
        return wxMpCardService;
    }
}
