package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IUserService;

/**
 * 模拟一个表现层，用于调用业务层
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Client {

    public static void main(String[] args) {

        for(int i=0;i<5;i++) {
//        IUserService userService = new UserServiceImpl();
            IUserService userService = (IUserService) BeanFactory.getBean("USERSERVICE");
            System.out.println(userService);
            userService.save();

        }
    }
}
