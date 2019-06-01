package com.itheima.service.impl;

import com.itheima.service.IUserService;

import java.util.Date;

/**
 * 用户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class UserServiceImpl2 implements IUserService {

    private String username;
    private Integer age;
    private Date birthday;

    public void setUserame(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void save() {
        System.out.println("调用持久层，执行了保存222222222222"+username+","+age+","+birthday);
    }
}
