package com.zk.szgh.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Classname ExceptionMsg
 * @Description TODO
 * @Date 2020/8/21 3:53 PM
 * @Created by nihui
 * @Version 1.0
 * @Description ExceptionMsg @see support-api
 */
public class ExceptionMsg {
    @JsonProperty("error_id")
    private String errorId;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("error_msg")
    private String errorMsg;


    public ExceptionMsg(String errorId, String errorCode, String errorMsg) {
        this.errorId = errorId;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ExceptionMsg() {
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
