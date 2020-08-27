package com.zk.szgh.bean.vo;

/**
 * @Classname UserVo
 * @Description TODO
 * @Date 2020/8/21 3:42 PM
 * @Created by nihui
 * @Version 1.0
 * @Description UserVo @see support-api
 */
public class UserVo {
    private String username;
    private String password;

    public UserVo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserVo() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
