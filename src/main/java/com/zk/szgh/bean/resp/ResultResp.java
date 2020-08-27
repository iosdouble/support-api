package com.zk.szgh.bean.resp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zk.szgh.exception.ExceptionMsg;
import com.zk.szgh.constant.ResultRespStatus;
import com.zk.szgh.exception.ParentException;
import com.zk.szgh.exception.ParentRuntimeException;

import java.util.Date;

/**
 * @Classname ResultResp
 * @Description TODO
 * @Date 2020/8/21 3:51 PM
 * @Created by nihui
 * @Version 1.0
 * @Description ResultResp @see support-api
 */
public class ResultResp<T> extends AbsJsonResp {

    @JsonProperty("date")
    private Date date=new Date();
    /**
     * normal
     * error
     * exception
     */
    @JsonProperty("status")
    private String status=ResultRespStatus.NORMAL;

    @JsonProperty("exception")
    private ExceptionMsg exceptionMsg;

    @JsonProperty("response")
    private T response;

    @JsonIgnore
    public void setException(ParentException parentException){
        this.exceptionMsg=parentException.getExceptionMsg();
    }

    @JsonIgnore
    public void setException(ParentRuntimeException parentRuntimeException){
        this.exceptionMsg=parentRuntimeException.getExceptionMsg();
    }

    public ResultResp(Date date, String status, ExceptionMsg exceptionMsg, T response) {
        this.date = date;
        this.status = status;
        this.exceptionMsg = exceptionMsg;
        this.response = response;
    }

    public ResultResp() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ExceptionMsg getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(ExceptionMsg exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
