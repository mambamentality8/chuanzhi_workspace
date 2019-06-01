package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试account的业务层
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;



    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){

        //3.执行业务层方法
        List<Account> accounts = accountService.findAll();
        for(Account account : accounts){
            System.out.println(account);
        }
    }


    /**
     * 测试查询一个
     */
    @Test
    public void testFindOne(){
         //3.执行业务层方法
        Account account = accountService.findById(1);
        System.out.println(account);
    }
    /**
     * 测试保存
     */
    @Test
    public void testSave(){
       //3.执行业务层方法
        Account account = new Account();
        account.setName("ee69");
        account.setMoney(1000f);
        accountService.save(account);
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdate(){
       //3.执行业务层方法
        Account account = accountService.findById(4);
        account.setMoney(5555f);
        accountService.update(account);
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete(){
        //3.执行业务层方法
        accountService.delete(4);
    }

}
