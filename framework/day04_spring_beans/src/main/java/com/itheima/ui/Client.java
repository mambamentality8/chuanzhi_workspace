package com.itheima.ui;

import com.itheima.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringIOC的入门案例
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.读取配置文件，获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据bean的id获取对象
       IUserService userService1 = ac.getBean("userService",IUserService.class);
//       IUserService userService2 = ac.getBean("userService",IUserService.class);
//
//       System.out.println(userService1 == userService2);

        System.out.println(userService1);

        ac.close();


    }
}
