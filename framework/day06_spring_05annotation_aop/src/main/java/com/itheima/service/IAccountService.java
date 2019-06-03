package com.itheima.service;

/**
 * 账户的业务层接口
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface IAccountService {

    /**
     * 保存
     */
    void saveAccount();

    /**
     * 更新
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除
     * @return
     */
    int deleteAccount();
}
