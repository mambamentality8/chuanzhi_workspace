package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IUserService;

/**
 * 用户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class UserServiceImpl implements IUserService {



//    此种方式创建对象会产生耦合，在实际开发中应该减少使用
//    private IUserDao userDao = new UserDaoImpl();

    private IUserDao userDao = (IUserDao)BeanFactory.getBean("USERDAO");

//    private int page =1 ;

    public void save() {
        int page = 1;
        System.out.println("page的值："+page);
        userDao.save();
        page++;

    }
}
