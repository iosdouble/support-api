package com.zk.szgh.bean.resp;

import com.zk.szgh.utils.json.JsonUtil;

/**
 * @Classname AbsJsonResp
 * @Description TODO
 * @Date 2020/8/21 3:48 PM
 * @Created by nihui
 * @Version 1.0
 * @Description AbsJsonResp @see support-api
 */
public abstract class AbsJsonResp implements IResp {

    @Override
    public String toJson() {
        return JsonUtil.toJsonAndLongToString(this);
    }

    @Override
    public String toString() {
        return this.toJson();
    }
}
