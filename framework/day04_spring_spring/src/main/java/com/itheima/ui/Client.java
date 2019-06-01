package com.itheima.ui;

import com.itheima.dao.IUserDao;
import com.itheima.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * SpringIOC的入门案例
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Client {
    /**
     * 获取Spring的IOC容器，并且根据bean的id获取对象
     *
     * ApplicationContext接口：
     *      它有3个常用实现类，今天只涉及两个。(AnnotationConfigApplicationContext今天不涉及)
     *          ClassPathXmlApplicationContext          实际开发中都是读取类路径
     *              它是用于读取类路径下的配置文件
     *          FileSystemXmlApplicationContext
     *              它是用于读取系统文件目录中的配置文件
     * BeanFactory和ApplicationContext的区别：
     *  BeanFactory是Spring中IOC的顶层工厂，但是，它提供创建对象的方式是采用延迟加载的方式。
     *  ApplicationContext是BeanFactory的子接口，在BeanFactory的基础上又进行了扩展，它默认情况下是采用立即加载的方式创建对象，且可根据配置调整成延迟加载。
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.读取配置文件，获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\zhy\\Desktop\\bean.xml");
        //2.根据bean的id获取对象
       IUserDao userDao = (IUserDao) ac.getBean("userDao");
       IUserService userService = ac.getBean("userService",IUserService.class);

        System.out.println("持久层对象："+userDao);
        System.out.println("业务层对象："+userService);

        userService.save();

        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IUserService userService = factory.getBean("userService",IUserService.class);
//        System.out.println(userService);

    }
}
