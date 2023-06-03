package com.miujoke.common.aspect;

import com.miujoke.common.annotation.IdempotentAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author miujoke
 * @date 2023/6/4 0:20
 */
@Aspect
@Order(2)
@Component
public class IdempotentAspect {

    @Around("@annotation(idempotentAnnotation)")
    public Object doAround(ProceedingJoinPoint joinPoint, IdempotentAnnotation idempotentAnnotation) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("开始访问： " + methodName);
        try {
            System.out.println("结束访问： " + methodName + "得到数据： "+ joinPoint.proceed());
            return joinPoint.proceed();
        }catch (Exception e){
            System.out.println("接口异常");
            return joinPoint.proceed();
        }

    }
}
