package com.zk.szgh.bean.resp;

import java.util.List;

/**
 * @Classname AbsPageResp
 * @Description TODO
 * @Date 2020/8/21 5:06 PM
 * @Created by nihui
 * @Version 1.0
 * @Description AbsPageResp @see support-api
 */
public class AbsPageResp<T> extends AbsJsonResp {
    private long count;
    private int offset;
    private int limit;
    private List<T> data;

    public AbsPageResp(long count, int offset, int limit, List<T> data) {
        this.count = count;
        this.offset = offset;
        this.limit = limit;
        this.data = data;
    }

    public AbsPageResp() {
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
