package com.itheima.factory;

import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;

/**
 * 模拟一个工厂，提供一个非静态方法用于创建某对象，需要在spring中能配置出来
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class InstanceFactory {

    public IUserService getUserService(){
        return new UserServiceImpl();
    }
}
