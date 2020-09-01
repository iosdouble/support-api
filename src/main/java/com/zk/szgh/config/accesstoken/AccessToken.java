package com.zk.szgh.config.accesstoken;

/**
 * @Classname AccessToken
 * @Description TODO
 * @Date 2020/8/14 3:02 PM
 * @Created by nihui
 * @Version 1.0
 * @Description AccessToken @see ruoyi
 */
public class AccessToken {
    private String access_token;

    private Integer expires_in;


    public AccessToken(String access_token, Integer expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public AccessToken() {
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
