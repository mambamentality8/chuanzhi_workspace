package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * SessionAttributes注解
 *      作用：把数据存入session域中
 *      属性：
 *          value：它是指定存入会话域中的名称（key的部分）,它和name属性作用一样。
 *          type：用于指定存入会话域中的数据类型
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Controller
@RequestMapping("springmvc")
@SessionAttributes(value="username",types = Integer.class)
public class SessionAttributesController {

    /**
     * 存入session域中
     * @return
     */
    @RequestMapping("testPut")
    public String putSessionScope(Model model){
        model.addAttribute("username","test");
        model.addAttribute("age",18);
        return "success";
    }

    /**
     * 从Session域中获取
     * @return
     */
    @RequestMapping("testGet")
    public String getSessionScope(ModelMap map){
        String username = (String)map.get("username");
        Integer age = (Integer)map.get("age");
        System.out.println(username+","+age);
        return "success";
    }

    /**
     * 清理Session域中的数据
     * @return
     */
    @RequestMapping("testClean")
    public String cleanSessionScope(SessionStatus status, HttpServletRequest request){
        System.out.println("进了清理方法：");
        HttpSession session = request.getSession();//session.setAttribute(name,value) 存入   session.removeAttribute(name);清除
        String username = (String)session.getAttribute("username");
        Integer age = (Integer)session.getAttribute("age");
        System.out.println(username+","+age);
        System.out.println("开始清理。。。。");
        status.setComplete();//session域中的数据过期了
        System.out.println("清理完成："+session);
        return "success";
    }
}
