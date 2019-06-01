package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;
import org.springframework.stereotype.Repository;

/**
 * 用户的持久层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Repository("userDao2")
public class UserDaoImpl2 implements IUserDao {


    public void save(){
        System.out.println("执行了保存用户22222222222222222222");
    }
}
