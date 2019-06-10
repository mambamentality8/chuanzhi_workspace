package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 原始ServletAPI作为控制器方法的参数
 *  HttpServletRequest
 *  HttpServletResponse
 *  HttpSession
 *  ServletContext
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 *
 */
@Controller
@RequestMapping("springmvc")
public class ParameterController3 {

    @RequestMapping("testParam3")
    public String testParam3(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);
        System.out.println(request.getSession());
        System.out.println(request.getSession().getServletContext());
        return "success";
    }
}
