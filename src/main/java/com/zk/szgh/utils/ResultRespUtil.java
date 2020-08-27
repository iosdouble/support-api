package com.zk.szgh.utils;

import com.zk.szgh.bean.resp.ResultResp;
import com.zk.szgh.constant.ResultRespStatus;
import com.zk.szgh.exception.ExceptionMsg;
import com.zk.szgh.exception.ParentException;
import com.zk.szgh.exception.ParentRuntimeException;

/**
 * @Classname ResultRespUtil
 * @Description TODO
 * @Date 2020/8/21 4:04 PM
 * @Created by nihui
 * @Version 1.0
 * @Description ResultRespUtil @see support-api
 */
public class ResultRespUtil {

    public static <T> ResultResp<T> doResultResp(Throwable throwable, T response){
        ResultResp<T> resultResp=new ResultResp<T>();
        if(throwable!=null) {
            if(ParentException.class.isAssignableFrom(throwable.getClass())) {
                ParentException parentException = (ParentException) throwable;
                resultResp.setStatus(ResultRespStatus.EXCEPTION);
                resultResp.setException(parentException);
            }else if(ParentRuntimeException.class.isAssignableFrom(throwable.getClass())) {
                ParentRuntimeException parentRuntimeException = (ParentRuntimeException) throwable;
                resultResp.setStatus(ResultRespStatus.EXCEPTION);
                resultResp.setException(parentRuntimeException);
            }else {
                resultResp.setStatus(ResultRespStatus.ERROR);

                ExceptionMsg exceptionMsg=new ExceptionMsg();
                exceptionMsg.setErrorCode("0");
                exceptionMsg.setErrorId("0");
                exceptionMsg.setErrorMsg(throwable.getMessage());
                resultResp.setExceptionMsg(exceptionMsg);
            }
        }
        resultResp.setResponse(response);
        return resultResp;
    }
}
