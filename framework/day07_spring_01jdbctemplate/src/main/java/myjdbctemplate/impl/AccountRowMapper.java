package myjdbctemplate.impl;

import com.itheima.domain.Account;
import myjdbctemplate.MyRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class AccountRowMapper implements MyRowMapper {


    public List mapRow(ResultSet rs) throws SQLException {
        System.out.println("结果集："+rs);
        List<Account> accounts = new ArrayList();
        while(rs.next()){
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setName(rs.getString("name"));
            account.setMoney(rs.getFloat("money"));
            accounts.add(account);
        }
        return accounts;
    }

}
