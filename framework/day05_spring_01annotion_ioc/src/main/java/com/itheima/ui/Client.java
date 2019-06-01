package com.itheima.ui;

import com.itheima.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Client {

    public static void main(String[] args) {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据bean的id获取对象
        IUserService userService1 = ac.getBean("userService", IUserService.class);
//        IUserService userService2 = ac.getBean("userService", IUserService.class);
//        IUserDao userDao = ac.getBean("userDao",IUserDao.class);

        IUserService userService2  = (IUserService)ac.getBean("userService");
//        System.out.println(userService);
//        System.out.println(userDao);

//        userService.save();

        System.out.println(userService1);
        ac.close();
    }
}
