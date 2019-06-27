package com.itheima.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: spring_day_03_02
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-18 16:10
 **/
@Component("logger2")
@Aspect
public class Logger {


    //配置切入点表达式
    @Pointcut("execution(* com.itheima.demo.*.*(..))")
    public void pt1() {
    }

    @AfterReturning(pointcut = "pt1()",returning = "returnVal")
    public void afterReturningPrintLog(JoinPoint joinPoint, Object returnVal) {
        System.out.println("你账户的余额为:"+returnVal);
        // System.out.println("后置通知执行了");
    }
}
