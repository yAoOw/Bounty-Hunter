package com.chason.nas.bountyhunter.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * <p>description: </p>
 * <p>Date: 2018/6/1</p>
 * <p>modify：</p>
 *
 * @author zhang qq.773935581
 **/

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.chason.nas.bountyhunter.controller..*.*(..))")
    public void webLog(){ }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("url:{}",request.getRequestURL().toString());
        log.info("http method:{}",request.getMethod());
        log.info("IP:{}",request.getRemoteAddr());
        log.info("args:{}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "jet",pointcut = "webLog()")
    public void doAfter(Object jet){
        log.info("response:{}",jet);
        log.info("spend time:{}",System.currentTimeMillis()-startTime.get());
    }
}
