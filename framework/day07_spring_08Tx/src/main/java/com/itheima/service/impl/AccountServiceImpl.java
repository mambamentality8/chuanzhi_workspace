package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 账户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public void transfer(String sourceName, String tragetName, Float money) {

        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
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
                return null;
            }
        });



    }
}
