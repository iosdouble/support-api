package com.zk.szgh.bean.vo;

/**
 * @Classname WeChatUserInfo
 * @Description TODO
 * @Date 2020/8/31 11:44 AM
 * @Created by nihui
 * @Version 1.0
 * @Description WeChatUserInfo @see support-api
 */
public class WeChatUserInfo {
    /**
     * 微信返回的code
     */
    private String code;
    /**
     * 非敏感的用户信息
     */
    private String rawData;
    /**
     * 签名信息
     */
    private String signature;
    /**
     * 加密的数据
     */
    private String encrypteData;
    /**
     * 加密密钥
     */
    private String iv;

    public WeChatUserInfo() {
    }

    public WeChatUserInfo(String code, String rawData, String signature, String encrypteData, String iv) {
        this.code = code;
        this.rawData = rawData;
        this.signature = signature;
        this.encrypteData = encrypteData;
        this.iv = iv;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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
