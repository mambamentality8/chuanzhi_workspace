package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取请求消息头和Cookie值的两个注解
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 *  @RequestHeader
 *      作用：获取指定消息头名称的值
 *      属性：
 *          value：指定消息头名称
 *  @CookieValue
 *      作用：获取指定名称的cookie
 *      属性：
 *          value：指定cookie的名称
 */
@Controller
@RequestMapping("springmvc")
public class OtherAnnotationController {

    @RequestMapping("testOtherAnnotation")
    public String testParam4(@RequestHeader("Accept-Language") String header, @CookieValue("JSESSIONID") String cookievalue){
        System.out.println(header+","+cookievalue);
        return "success";
    }
}
