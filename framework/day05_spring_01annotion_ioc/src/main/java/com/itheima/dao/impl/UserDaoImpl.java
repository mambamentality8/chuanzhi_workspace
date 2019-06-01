package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;
import org.springframework.stereotype.Repository;

/**
 * 用户的持久层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Repository("userDao1")
public class UserDaoImpl implements IUserDao {


    public void save(){
        System.out.println("执行了保存用户111111111111111111111111");
    }
}
