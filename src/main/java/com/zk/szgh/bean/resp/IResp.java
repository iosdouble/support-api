package com.zk.szgh.bean.resp;

import java.io.Serializable;

/**
 * @Classname IResp
 * @Description TODO
 * @Date 2020/8/21 3:47 PM
 * @Created by nihui
 * @Version 1.0
 * @Description IResp @see support-api
 */
public interface IResp extends Serializable {
    /**
     * 将本对象序列化为JSON数据
     * @return
     */
    public String toJson();
}
