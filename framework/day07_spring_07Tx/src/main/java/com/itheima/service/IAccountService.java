package com.itheima.service;

import com.itheima.domain.Account;

/**
 *  账户的业务层接口
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface IAccountService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 转账
     * @param sourceName
     * @param tragetName
     * @param money
     */
    void transfer(String sourceName, String tragetName, Float money);
}
