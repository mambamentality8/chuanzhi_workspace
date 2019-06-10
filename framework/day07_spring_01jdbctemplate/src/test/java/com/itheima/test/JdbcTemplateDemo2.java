package com.itheima.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate基于spring的ioc配置
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class JdbcTemplateDemo2 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        jt.execute("insert into account(name,money)values ('ddd',2345)");
















//        //spring内置数据源(连接池)
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/ee69_spring");
//        ds.setUsername("root");
//        ds.setPassword("1234");
//
//        JdbcTemplate jt = new JdbcTemplate();
//        jt.setDataSource(ds);
//        jt.execute("insert into account(name,money) values('ccc',1000)");
    }
}
