package com.itheima.controller;

import com.itheima.com.itheima.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * POJO类型的参数绑定(实体类的参数绑定）
 *  绑定要求：
 *      请求参数中key的部分必须和实体类中属性的名称保持一致
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 */
@Controller
@RequestMapping("springmvc")
public class ParameterController2 {

    @RequestMapping("testParam2")
    public String testParam2(Account account){
        System.out.println(account+","+account.getAddressMap());
        return "success";
    }
}
