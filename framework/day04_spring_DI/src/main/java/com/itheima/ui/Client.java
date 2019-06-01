package com.itheima.ui;

import com.itheima.service.IUserService;
import org.springframework.context.ApplicationContext;
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
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据bean的id获取对象
//       IUserService userService = ac.getBean("userService",IUserService.class);
//        IUserService userService = ac.getBean("userService2",IUserService.class);
        IUserService userService = ac.getBean("userService3",IUserService.class);
        userService.save();

    }
}
