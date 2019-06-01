package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 用户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * XML和注解配置IOC，在配置形式上不同，但是解决的问题是一样的，都是用于解耦。
 *
 * 注解一共分为4类：
 *
 * 用于创建对象的
 *      相对于xml配置就是：<bean id="" class=""></bean>
 *      @Component： 是组件的含义
 *          作用：用于把当前类的对象存入ioc容器。
 *          属性：
 *              value：用于指定获取bean对象时的id。当不指定时，默认值是当前类名，并且首字母小写。
 *      由此注解衍生出的三个注解
 *          @Controller         @Service        @Repository
 *          表现层                业务层          持久层
 *          他们三个是spring框架为我们提供更强语义化的注解，可以让开发者通过注解即知道是哪一层的类。但是没有要求必须对应使用
 *
 * 用于注入数据的
 *      相当于xml配置就是：构造函数注入或者set方法注入。<property name="" value="" || ref="" ></property>
 *      @Autowired:
 *          作用：自动按照类型注入。如果找不到匹配的类型，则会报错(报什么错是看required属性)。如果只有唯一的一个类型匹配，则注入成功。
 *               如果有多个匹配时，还会使用变量名称作为bean的id，在匹配的类型对象列表中，根据id获取，如果能找到依然可以注入成功。
 *               找不到就报错。
 *          属性：
 *              required：是否必须注入成功。默认值是true，表示必须注入成功。通常情况下都是取默认值
 *          细节：
 *              使用注解注入时,set方法和构造函数就不是必须的了。
 *      @Qualifier
 *          作用：在自动按照类型注入的基础之上，再按照bean的id注入。在给类的成员注入时，不能独立使用。（后面纯注解会讲，它独立使用的场景）
 *          属性：
 *              value：用于指定bean的id。
 *      @Resource
 *          作用：直接使用bean的id来注入。
 *          属性：
 *              name：用于指定bean的id。
 *      @Value:
 *          作用：用于指定基本类型或者String类型的数据。它通常的作用都是用于读取properties文件中的配置
 *               需要借助spring的el表达式。写法：${key}   读取的就是properties文件的value
 *          属性：
 *              value：用于指定数据内容
 * 用于改变作用范围的
 *      相当于xml配置就是：bean标签的scope属性
 *      @Scope:
 *          作用：用于指定当前bean的作用范围
 *          属性：
 *              value：用于指定作用范围的值。
 *                     取值和xml配置时是一模一样的。
 * 和生命周期相关的
 *      相当于xml配置就是：bean标签的init-method和destory-method属性
 *      @PostConstruct
 *             作用：用于指定初始化方法
 *      @PreDestroy
 *              作用：用于指定销毁方法
 */
@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("userDao2")
    //@Resource(name="userDao1")
    private IUserDao userDao = null;

    @Value("泰斯特")
    private String  name ;

    @Value("${jdbc.driver}")
    private String driver;

    public void save(){
        System.out.println(driver);
        userDao.save();
    }


    @PostConstruct
    public void init(){
        System.out.println("对象初始化了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("对象销毁了");
    }
}
