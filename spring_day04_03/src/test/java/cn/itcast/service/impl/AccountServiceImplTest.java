package cn.itcast.service.impl;

import cn.itcast.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AccountServiceImplTest {

    @Autowired
    private IAccountService accountService;


    @Test
    public void transfer() {
        accountService.transfer("aaa","bbb",100f);
    }
}