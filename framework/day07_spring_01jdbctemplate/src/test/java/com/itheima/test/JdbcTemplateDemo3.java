package com.itheima.test;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JdbcTemplate的CRUD
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
//        jt.update("insert into account(name,money)values(?,?)","eee",3456f);
        //更新
//        jt.update("update account set money = ? where id = ?",5678f,3);
        //删除
//        jt.update("delete from account where id = ? ",2);
        //查询所有
//       List<Account> accounts =  jt.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
//        System.out.println(accounts);
        //查询一个
//        List<Account> accounts = jt.query("select * from account where id = ? ",new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(accounts.isEmpty()?"没有数据":accounts.get(0));
        //查询返回一行一列（使用聚合函数）
        List<Long> counts = jt.query("select count(*) from account",new CountRowMapper());
        System.out.println(counts);

//        Long count = jt.queryForObject("select count(*) from account",Long.class);
//        System.out.println("queryForObject:"+count);



    }
}
class CountRowMapper implements  RowMapper<Long>{
    @Override
    public Long mapRow(ResultSet resultSet, int i) throws SQLException {

        long count =  resultSet.getLong(1);
        System.out.println("总记录数是："+count);
        return count;
    }
}