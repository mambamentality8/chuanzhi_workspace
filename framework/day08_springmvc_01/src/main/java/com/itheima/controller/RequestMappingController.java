package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @RequestMapping注解介绍
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 * @RequestMapping
 *  作用：用于建立浏览器请求和控制器方法的对应关系。
 *       当浏览器请求URL和RequestMapping注解的值对应上，SpringMVC会通过反射调用控制器方法。
 *  属性：
 *      value：用于指定映射的值
 *             注意事项：映射的值可以写/，也可以不写
 *             细节：页面上可以直接写springmvc的映射，而不用写${pageContext.request.contextPath}
 *      method：用于限定特定的请求类型。
 *      header：用于限定特定请求消息头
 *      params：用于限定有特定的请求参数，但是它不会做逻辑判断
 *
 *  出现位置：
 *      它可以写在方法上，用于建立方法和请求URL的对应关系。
 *      还可以写在类上，用于窄化URL
 *
 *      http://localhost:8080/user/save
 *      http://localhost:8080/user/update
 *      http://localhost:8080/user/delete?id=1
 *
 */
@Controller
@RequestMapping("springmvc")
public class RequestMappingController {

    /**
     * 演示@RequestMapping
     * @return
     */
    @RequestMapping(value="testRequestMapping",method = RequestMethod.GET,headers = {"Accept-Language"},params = {"money>1000"})
    public String testRequestMapping(){
        System.out.println("接收到请求，可以调用service");
        return "success";
    }
}
