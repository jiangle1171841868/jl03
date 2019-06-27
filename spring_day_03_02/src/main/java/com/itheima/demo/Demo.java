package com.itheima.demo;

import org.springframework.stereotype.Component;

/**
 * @program: spring_day_03_02
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-18 16:11
 **/
@Component("demo")
public class Demo implements IDemo {
    @Override
    public int account() {
        return 100;
    }
}
