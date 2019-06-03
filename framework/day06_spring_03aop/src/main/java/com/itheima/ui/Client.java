package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，调用业务层
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Client {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取对象
        IAccountService accountService = ac.getBean("accountService",IAccountService.class);


        accountService.saveAccount();
        accountService.updateAccount(10);
        accountService.deleteAccount();
    }
}
