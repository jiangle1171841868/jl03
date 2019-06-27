package com.itheima.service;

import com.itheima.config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IAccountServiceTest2 {

    private IAccountService accountService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        accountService = (IAccountService) ac.getBean("accountService");
    }

    @Test
    public void saveAccount() {
        accountService.saveAccount();
    }

    @Test
    public void updateAccount() {
        accountService.updateAccount(1);
    }



}