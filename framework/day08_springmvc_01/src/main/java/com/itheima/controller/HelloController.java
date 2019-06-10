package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 第一个控制器
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Controller
public class HelloController{

    /**
     * 控制器的方法
     * @return
     */
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("HelloController的sayHello方法执行了。。。。");
        return "success";
    }
}
