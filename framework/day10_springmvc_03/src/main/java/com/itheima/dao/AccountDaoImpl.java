package com.itheima.dao;

import com.itheima.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount(Account account) {
        System.out.println("保存了账户");
    }

    @Override
    public List<Account> findAllAccount() {
        System.out.println("查询了所有账户");
        return null;
    }
}
