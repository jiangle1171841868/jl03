package com.itheima.service.impl;

import com.itheima.service.IAccountService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @program: spring_day_03_02
 * @description:
 * @author: Mr.Jiang
 * @create: 2019-06-17 19:54
 **/
@Component("accountService")
public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("保存账户");
       // int i=1/0;
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新账户");

    }


}
