package com.zk.szgh.config.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @class: WxMaProperties
 * @description: TODO
 * @date 2020/8/28 9:24 AM
**/
@ConfigurationProperties(prefix = "wx.miniapp")
public class WxMaProperties {

    private List<Config> configs;

    public WxMaProperties() {
    }



    public WxMaProperties(List<Config> configs) {
        this.configs = configs;
    }


    public List<Config> getConfigs() {
        return configs;
    }

    public void setConfigs(List<Config> configs) {
        this.configs = configs;
    }

    public static class Config {
        /**
         * 设置微信小程序的appid
         */
        private String appid;

        /**
         * 设置微信小程序的Secret
         */
        private String secret;

        /**
         * 设置微信小程序消息服务器配置的token
         */
        private String token;

        /**
         * 设置微信小程序消息服务器配置的EncodingAESKey
         */
        private String aesKey;

        /**
         * 消息格式，XML或者JSON
         */
        private String msgDataFormat;


        public Config(String appid, String secret, String token, String aesKey, String msgDataFormat) {
            this.appid = appid;
            this.secret = secret;
            this.token = token;
            this.aesKey = aesKey;
            this.msgDataFormat = msgDataFormat;
        }


        public Config() {
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

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAesKey() {
            return aesKey;
        }

        public void setAesKey(String aesKey) {
            this.aesKey = aesKey;
        }

        public String getMsgDataFormat() {
            return msgDataFormat;
        }

        public void setMsgDataFormat(String msgDataFormat) {
            this.msgDataFormat = msgDataFormat;
        }
    }

}
