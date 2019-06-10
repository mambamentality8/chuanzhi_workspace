package com.itheima.controller;

import com.itheima.com.itheima.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求参数绑定的类型转换
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 */
@Controller
@RequestMapping("springmvc")
public class ParameterController4 {

    @RequestMapping("testParam4")
    public String testParam4(Account account){
        System.out.println(account);
        return "success";
    }
}
