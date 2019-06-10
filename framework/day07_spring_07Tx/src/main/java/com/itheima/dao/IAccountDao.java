package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * 账户的持久层接口
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface IAccountDao {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    Account findByName(String name);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);
}
