package com.itheima.controller;

import com.itheima.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 第一个控制器
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Controller
public class ExceptionController {

    /**
     * 控制器的方法
     * @return
     */
    @RequestMapping("/error")
    public String sayHello() throws CustomException {
       throw new CustomException("抛出客户异常");
    }
}
