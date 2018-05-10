package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * web层日志切面
 * @author
 * @description
 * @create 2017-10-31 下午2:03
 **/
@Aspect
@Order(5)
@Component
public class HttpAspect {

  private  final static   Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    //因为要计算处理时间,不能采用基本类型定义,因为存在线程同步问题,这里采用ThreadLocal
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    //切入点
    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void log(){

    }

    //切面支持
    @Before("log()")
    public void doBefore(JoinPoint joinPoint)throws Throwable {
        startTime.set(System.currentTimeMillis());
        //url
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("header={}",request.getHeader("accpet"));

        //method
        logger.info("class.method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //类方法
        //args
        logger.info("args={}", Arrays.toString(joinPoint.getArgs()));

        logger.info("before------");
        //System.out.println("111111");
    }

    //切面支持
    @After("log()")
    public void doAfter(){
        logger.info("after-------");
        //System.out.println("222222222222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object)throws Throwable {
        logger.info("response={}",object);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));

    }
   /* //也可以通过环绕的方式记录处理时间
    @Around("log()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


        logger.info("around-------start------");
        Long start = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        logger.info("around-------end------"+(System.currentTimeMillis()-start));

    }*/
}
