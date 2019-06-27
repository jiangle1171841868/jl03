package com.itheima.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class IAccountServiceTest {

    private IAccountService accountService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
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