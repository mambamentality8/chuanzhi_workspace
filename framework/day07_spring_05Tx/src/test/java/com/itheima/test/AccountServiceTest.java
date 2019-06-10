package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试账户的业务层
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindOne(){
        Account account = accountService.findById(1);
        System.out.println(account);
    }

    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb",100f);
    }
}
