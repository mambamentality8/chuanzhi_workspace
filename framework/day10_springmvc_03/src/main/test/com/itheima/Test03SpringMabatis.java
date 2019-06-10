package com.itheima;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试 spring 整合 mybatis  *
 * @author 黑马程序员  *
 * @Company http://www.ithiema.com  *
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test03SpringMabatis {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll() {
        List list = accountService.findAllAccount();
        System.out.println(list);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("测试账号");
        account.setMoney(1234f);
        accountService.saveAccount(account);
    }
}