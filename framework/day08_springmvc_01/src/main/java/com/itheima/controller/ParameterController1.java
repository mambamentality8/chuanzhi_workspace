package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 基本类型和String类型的参数绑定
 *  绑定要求：
 *      请求参数中的key的部分，必须和控制器方法的形参变量名称保持一致
 *
 * @RequestParam
 *  作用：建立请求参数和控制器方法形参的对应关系。
 *  属性：
 *      value：指定请求参数中key的值
 */
@Controller
@RequestMapping("springmvc")
public class ParameterController1 {

    @RequestMapping("testParam1")
    public String testParam1(@RequestParam("name") String username, Integer age){
        System.out.println(username+","+age);
        return "success";
    }
}
