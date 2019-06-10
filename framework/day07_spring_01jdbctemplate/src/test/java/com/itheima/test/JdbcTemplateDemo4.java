package com.itheima.test;

import com.itheima.domain.Account;
import myjdbctemplate.JdbcTemplateTemp;
import myjdbctemplate.impl.AccountRowMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * JdbcTemplate的CRUD
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args)throws  Exception {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplateTemp jt = ac.getBean("jdbcTemplateTemp",JdbcTemplateTemp.class);
        //3.执行操作
//        jt.update("delete from account where id = ? ",2);
        //查询所有
        List<Account> accounts =  (List)jt.query("select * from account",new AccountRowMapper());
        System.out.println(accounts);
//        //查询一个
//        List<Account> accounts = jt.query("select * from account where id = ? ",new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(accounts.isEmpty()?"没有数据":accounts.get(0));
//        //查询返回一行一列（使用聚合函数）
//        List<Long> counts = jt.query("select count(*) from account",new CountRowMapper());
//        System.out.println(counts);
//
//        Long count = jt.queryForObject("select count(*) from account",Long.class);
//        System.out.println("queryForObject:"+count);


    }
}
