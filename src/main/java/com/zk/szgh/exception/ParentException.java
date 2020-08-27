package com.zk.szgh.exception;

import com.zk.szgh.utils.json.JsonUtil;

/**
 * @Classname ParentException
 * @Description TODO
 * @Date 2020/8/21 3:55 PM
 * @Created by nihui
 * @Version 1.0
 * @Description ParentException @see support-api
 */
public class ParentException extends Exception{
    private ExceptionMsg exceptionMsg=new ExceptionMsg();


    public ParentException(ExceptionMsg exceptionMsg) {
        super();
        this.exceptionMsg = exceptionMsg;
    }

    public ParentException(String errorCode ,String errorMsg) {
//		exceptionMsg.setErrorId(ExceptionIdUtil.getId());
        exceptionMsg.setErrorCode(errorCode);
        exceptionMsg.setErrorMsg(errorMsg);
    }

    public ExceptionMsg getExceptionMsg(){
        return this.exceptionMsg;
    }

    public void setErrorId(String errorId) {
        this.exceptionMsg.setErrorId(errorId);
    }

    public void setErrorCode(String projectErrorCode) {
        String errorCode=this.exceptionMsg.getErrorCode();
        errorCode = projectErrorCode+"-"+errorCode;
        this.exceptionMsg.setErrorCode(errorCode);
    }

    /***
     * 转换JSON格式
     * @return
     */
    private String toJson(){
//		if(StringUtils.isBlank(exceptionMsg.getErrorId())){
//			exceptionMsg.setErrorId(ExceptionIdUtil.getId());
//		}
        String responseStr=JsonUtil.toJson(exceptionMsg);
        return responseStr;
    }

    /**
     * 重写Exception.getMessage()，返回规定的json格式异常
     */
    @Override
    public String getMessage() {
        return toJson();
    }

}
