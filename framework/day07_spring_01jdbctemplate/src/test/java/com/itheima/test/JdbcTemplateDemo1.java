package com.itheima.test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 回顾最基本用法
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //spring内置数据源(连接池)
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbctemplate");
        ds.setUsername("root");
        ds.setPassword("root");

        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money) values('ccc',1000)");
    }
}
