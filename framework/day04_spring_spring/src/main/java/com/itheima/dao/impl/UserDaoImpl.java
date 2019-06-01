package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;

/**
 * 用户的持久层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class UserDaoImpl implements IUserDao {

    public void save() {
        System.out.println("保存了用户");
    }
}
