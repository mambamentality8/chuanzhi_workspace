package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 保存   * @param account
     */
    void saveAccount(Account account);

    /**
     * 查询所有   * @return
     */
    List<Account> findAllAccount();
}
