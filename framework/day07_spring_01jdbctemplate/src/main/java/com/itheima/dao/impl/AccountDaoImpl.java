package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 账户的持久层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {


    @Override
    public Account findById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id = ? ",new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account findByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ? ",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name = ? , money = ? where id = ? ",account.getName(),account.getMoney(),account.getId());
    }
}
