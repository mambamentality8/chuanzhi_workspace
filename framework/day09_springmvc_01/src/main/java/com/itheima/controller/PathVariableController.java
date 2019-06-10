package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * PathVariable注解：
 *      作用：用于把请求URL中的值，使用占位符的方式，给控制器方法的形参赋值
 *      属性：
 *          value:用于指定占位符中的名称
 *
 * 此时我们需要模拟四种请求方式：
 *  需要借助springmvc提供的过滤器
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Controller
@RequestMapping("springmvc")
public class PathVariableController {

    /**
     * 删除用户，需要delete方式的请求
     * @return
     */
    @RequestMapping(value = "deleteUser/{userid}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userid") Integer id){
        System.out.println("接收到用户的id，调用业务层删除："+id);
        return "success";
    }


}
