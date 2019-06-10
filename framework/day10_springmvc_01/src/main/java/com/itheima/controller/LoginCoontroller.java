package com.itheima.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

public class LoginCoontroller {
    @RequestMapping("/login")
    public String login(Model model) throws Exception {
        return "login";
    }

    //登陆提交 //userid：用户账号，pwd：密码
    @RequestMapping("/loginsubmit")
    public String loginsubmit(HttpSession session, String userid, String pwd) throws Exception {
        //向 session 记录用户身份信息
        session.setAttribute("activeUser", userid);
        return "redirect:/main.jsp";
    }

    //退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        //session 过期
        session.invalidate();
        return "redirect:index.jsp";
    }
}
