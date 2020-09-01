package com.zk.szgh.bean.vo;

/**
 * @Classname LoginUser
 * @Description TODO
 * @Date 2020/9/1 11:02 AM
 * @Created by nihui
 * @Version 1.0
 * @Description LoginUser @see support-api
 */
public class LoginUser {
    private String code;
    private String signature;
    private String rawData;
    private String encrypteData;
    private String iv;

    public LoginUser() {
    }

    public LoginUser(String code, String signature, String rawData, String encrypteData, String iv) {
        this.code = code;
        this.signature = signature;
        this.rawData = rawData;
        this.encrypteData = encrypteData;
        this.iv = iv;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getEncrypteData() {
        return encrypteData;
    }

    public void setEncrypteData(String encrypteData) {
        this.encrypteData = encrypteData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
