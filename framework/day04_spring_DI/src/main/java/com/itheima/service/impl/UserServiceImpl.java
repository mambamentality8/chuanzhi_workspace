package com.itheima.service.impl;

import com.itheima.service.IUserService;

import java.util.Date;

/**
 * 用户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class UserServiceImpl implements IUserService {

    private String username;
    private Integer age;
    private Date birthday;

    public UserServiceImpl(String username, Integer age, Date birthday) {
        this.username = username;
        this.age = age;
        this.birthday = birthday;
    }

    public void save() {
        System.out.println("调用持久层，执行了保存"+username+","+age+","+birthday);
    }
}
