package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 账户的控制器  * @author 黑马程序员  * @Company http://www.ithiema.com  * @Version 1.0
 */
@Controller("accountController")
@RequestMapping("/account")
public class AccountController {

    @RequestMapping("/findAllAccount")
    public String findAllAccount() {
        System.out.println("执行了查询账户");
        return "success";
    }
}
