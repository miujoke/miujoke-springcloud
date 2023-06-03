package com.miujoke.common.aspect;


import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author miujoke
 * @date 2023/6/3 23:24
 * 日志切面类
 */
@Aspect
@Component
public class LoggingAspect {

    @Before(value = "@annotation(com.miujoke.common.annotation.LogExecution)")
    public void beforeMethodExecution(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("开始访问： " + methodName);
    }

   @AfterReturning(
           value = "@annotation(com.miujoke.common.annotation.LogExecution)",
           returning = "result")
    public void afterMethodExecution(JoinPoint joinPoint, Object result){
       String methodName = joinPoint.getSignature().getName();
       System.out.println("结束访问： " + methodName + "得到数据： "+ result);
   }
}
