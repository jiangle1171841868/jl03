package cn.itcast.dao;

import cn.itcast.pojo.Account;

public interface IAccountDao {
    Account queryAccountByName(String name);

    void updateAccount(Account account);
}
