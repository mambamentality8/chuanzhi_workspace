package com.itheima.service.impl;

import com.itheima.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
//        int i=1/0;
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新了账户"+i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除了账户");
        return 0;
    }
}
