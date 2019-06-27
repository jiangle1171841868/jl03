package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: spring_day_03_02
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-17 20:51
 **/
@Configuration//声明是一个注解类
@ComponentScan("com.itheima")//开启注解扫描
@EnableAspectJAutoProxy//开启aop的注解扫描
public class SpringConfiguration {
}
