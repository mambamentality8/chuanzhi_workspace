package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * JdbcTemplate的CRUD
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class JdbcTemplateDemo5 {

    public static void main(String[] args)throws  Exception {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);


        Account account = accountDao.findById(4);
        System.out.println(account);

        account.setMoney(3333f);
        accountDao.updateAccount(account);

    }
}
