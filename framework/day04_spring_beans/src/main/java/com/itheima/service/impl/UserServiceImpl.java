package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.service.IUserService;

/**
 * 用户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class UserServiceImpl implements IUserService {



//    此种方式创建对象会产生耦合，在实际开发中应该减少使用
    private IUserDao userDao = new UserDaoImpl();

    public UserServiceImpl(){
        System.out.println("对象创建了");
    }

    public void init(){
        System.out.println("对象初始化了");
    }


    public void destroy(){
        System.out.println("对象销毁了");
    }


    public void save() {
        userDao.save();
    }
}
