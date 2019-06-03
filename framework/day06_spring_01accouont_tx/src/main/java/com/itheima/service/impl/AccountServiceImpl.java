package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

import java.util.List;
import java.util.UUID;

/**
 * 账户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;



    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer id) {
        return  accountDao.findById(id);

    }

    public void save(Account account) {
         accountDao.save(account);
    }

    public void update(Account account) {
         accountDao.update(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);

    }

    public void transfer(String sourceName, String targetName, Float money) {

            //1.根据名称查询转出账户
            Account source = accountDao.findByName(sourceName);
            //2.根据名称查询转入账户
            Account target = accountDao.findByName(targetName);
            //3.转出账户减钱
            source.setMoney(source.getMoney()-money);
            //4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            //5.更新转出账户
            accountDao.update(source);
            int i=1/0;//模拟转账异常
            //6.更新转入账户
            accountDao.update(target);



    }

    public String generateCode(String username){
        return UUID.randomUUID().toString()+"."+username;
    }
}
