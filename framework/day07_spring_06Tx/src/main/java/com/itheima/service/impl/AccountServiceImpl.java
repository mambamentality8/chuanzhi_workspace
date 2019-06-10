package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//针对查询的
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;


    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)//针对增删改的
    public void transfer(String sourceName, String tragetName, Float money) {
        //1.根据名称查询转出账户
        Account source = accountDao.findByName(sourceName);
        //2.根据名称查询转入账户
        Account target = accountDao.findByName(tragetName);
        //3.转出账户减钱
        source.setMoney(source.getMoney()-money);
        //4.转入账户加钱
        target.setMoney(target.getMoney()+money);
        //5.更新转出账户
        accountDao.updateAccount(source);
        int i=1/0;
        //6.更新转入账户
        accountDao.updateAccount(target);
    }
}
