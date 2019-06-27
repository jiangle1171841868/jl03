package com.itheima.demo;

import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class DemoTest {
    private IDemo demo;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext2.xml");
        demo = (IDemo) ac.getBean("demo");
    }

    @Test
    public void account() {
        demo.account();
    }
}