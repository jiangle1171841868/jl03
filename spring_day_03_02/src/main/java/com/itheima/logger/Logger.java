package com.itheima.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @program: spring_day_03_02
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-17 19:56
 **/
@Component("logger")
@Aspect//声明是切面类
public class Logger {


    //配置切入点表达式
    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pt1() {
    }
  /*  public void printLog() {
        System.out.println("Logger类中的printLog方法开始记录日志了。。。");
    }*/

    //前置通知:在方法执行之前进行增强
    //应用场景:权限校验(校验不通过,抛出异常) 记录日志等
    //参数:连接点对象JoinPoint作用:获取方法 目标对象  代理对象
  /*  @Before("pt1()")
    public void beforePrintLog(JoinPoint joinPoint) {

        //设置登录用户名
        String loginName = "admin";
        System.out.println("方法名称:" + joinPoint.getSignature().getName());
        System.out.println("目标对象:" + joinPoint.getTarget().getClass().getName());
        System.out.println("代理对象:" + joinPoint.getThis().getClass().getName());

        //判断是不是要执行的方法
        if (joinPoint.getSignature().getName().equals("saveAccount")) {
            //判断有没有登录权限,没有则抛出异常
            if (!loginName.equals("admin")) {
                //抛出异常
                throw new RuntimeException("您没有权限执行方法：" + joinPoint.getSignature().getName() + "，类型为："
                        + joinPoint.getTarget().getClass().getName());
            }
        }

    }*/

    //后置通知
    //在方法执行之后进行增强
    //应用场景:与业务相关的，如网上营业厅查询余额后，自动下发短信功能(将方法的返回值类型进行增强)
    //参数1:连接点对象JoinPoint作用:获取方法 目标对象  代理对象
    //参数2:目标方法执行后的返回值,类型是object，“参数名”可自定义
    //不管xml配置还是注解配置 如果有Object returnVal 就需要配置returning属性
    //returning:配置方法中的参数名字，与通知方法的第二个参数的名字，名字必须对应。
    //在运行的时候，spring会自动将返回值传入该参数中。
   /* @AfterReturning(pointcut = "pt1()", returning = "returnVal")
    public void afterReturningPrintLog(JoinPoint joinPoint, Object returnVal) {
        System.out.println("你账户的余额为:" + returnVal);
        // System.out.println("后置通知执行了");
    }*/

    //异常通知
    //使用场景:处理异常
    //参数1:连接对象  作用:获取目标方法   目标对象 代理对象
    //参数2:目标方法抛出的异常
    @AfterThrowing(pointcut = "pt1()", throwing = "throwable")
    public void afterThrowingPrintLog(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("管理员你好:" + joinPoint.getTarget().getClass().getName() + "类的" + joinPoint.getSignature().getName()
                + "方法发生了异常,信息为:" + throwable.getMessage());
    }

    //最终通知
    //作用：不管目标方法是否发生异常，最终通知都会执行（类似于finally代码功能）
    //应用场景：释放资源 （关闭文件、 关闭数据库连接、 网络连接、 释放内存对象 ）
  /*  @After("pt1()")
    public void afterPrintLog() {
        System.out.println("最终通知执行了");
    }*/


    //环绕通知应用场景:记录日志、效率监控、权限校验、缓存数据、事务
    //参数ProceedingJoinPoint:可执行连接点
 /*   @Around("pt1()")
    public Object around(ProceedingJoinPoint pjp) {
        Object obj = null;
        try {
            System.out.println("前置通知");
            pjp.proceed();//相当于mothed.invoke()
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }
        return obj;
    }
*/

}
