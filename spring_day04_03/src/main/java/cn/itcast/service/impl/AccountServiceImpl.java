package cn.itcast.service.impl;

import cn.itcast.dao.IAccountDao;
import cn.itcast.pojo.Account;
import cn.itcast.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountservice")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    @Override
    public void transfer(String sourceName, String targetName, Float money) {


        //通过账户名称查询到转出方账户和转入方账户
        Account source = accountDao.queryAccountByName(sourceName);
        Account target = accountDao.queryAccountByName(targetName);

        //转出方的账户减去money
        source.setMoney(source.getMoney() - money);

        //转入方的账户加上money
        target.setMoney(target.getMoney() + money);

        //执行修改
        accountDao.updateAccount(source);

        //出现异常
        //int x = 1/0;

        accountDao.updateAccount(target);


    }
}
