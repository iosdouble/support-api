package com.zk.szgh.aspectj;

import com.zk.szgh.annotation.OptionLog;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Classname LogAspect
 * @Description TODO
 * @Date 2020/8/21 10:02 AM
 * @Created by nihui
 * @Version 1.0
 * @Description LogAspect @see support-api
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 编辑切入点
     */
    @Pointcut("@annotation(com.zk.szgh.annotation.OptionLog)")
    public void logPointCut(){

    }


    /**
     * 在操作完成返回之后
     * @param joinPoint
     * @param jsonResult
     */
    @AfterReturning(pointcut = "logPointCut()",returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult){
        handleLog(joinPoint,null,jsonResult);
    }

    @AfterThrowing(value = "logPointCut()",throwing = "e")
    public void doAterThrowing(JoinPoint joinPoint,Exception e){
        handleLog(joinPoint,e,null);
    }

    protected void handleLog(final JoinPoint joinPoint,final Exception e,Object jsonResult){
        try{
            // 获取到注解
            OptionLog controllerLog = getAnnotationLog(joinPoint);
            if (controllerLog==null){
                return ;
            }
            //获取当前用户


        }catch (Exception ee){

        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private OptionLog getAnnotationLog(JoinPoint joinPoint) throws Exception
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(OptionLog.class);
        }
        return null;
    }
}
