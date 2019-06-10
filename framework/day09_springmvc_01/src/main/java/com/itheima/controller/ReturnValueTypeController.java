package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制器方法的返回值类型
 *      String
 *      void
 *      ModelAndView
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Controller
@RequestMapping("springmvc")
public class ReturnValueTypeController {

    /**
     * 方法的返回值是一个字符串。
     *     它会借助视图解析器，来给我们查找并展示视图。
     *     视图解析器，会根据前缀，前往指定位置查找
     *     根据后缀，查找指定扩展名的文件。
     *     文件的名称就是当前方法的返回值
     * 我们可以通过给控制器方法添加参数：Model或者ModelMap  Map
     *      给他们添加数据，并且可以响应到浏览器
     *
     * 前往视图的方式：
     *      默认情况下是使用请求转发。
     *      转发：
     *          简写方式：
     *              return 视图名称  借助视图解析器实现视图展示
     *          标准方式：
     *              return "forward:视图的完整URI"  和视图解析器无关
     *      重定向：
     *          标准方式："redirect:定向的地址"
     *      转发：  1次请求   地址栏不变   服务器行为   请求域中的数据不丢失      只能在当前应用内部跳转
     *      重定向：2次请求   地址栏改变   浏览器行为   请求域中的数据丢失        可以定向到应用外部外部
     *
     * @return
     */
    @RequestMapping("testReturnString")
    public String returnString(Model model){
        model.addAttribute("msg","通过model添加的数据");//放到请求域中
        System.out.println("returnString方法执行了。。。。");
        return "success";  //使用的是视图解析器。
        //request.getRequestDispatcher("转发地址").forward(request,response);
//        return "forward:/WEB-INF/pages/success.jsp";
//        return "redirect:http://www.baidu.com";
    }

    /**
     * 控制器方法返回值是Void
     *  当返回值是Void，表示希望我们自己使用原始ServletAPI来实现转发或者重定向
     */
    @RequestMapping("testReturnVoid")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //请求转发
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
//        response.sendRedirect("http://www.baidu.com");
    }

    /**
     * 控制器方法返回值是SpringMVC提供的对象：ModelAndView
     *      其实我们的控制器方法，除了没有返回值（void）的时候，其余全是返回ModelAndView
     * @return
     */
    @RequestMapping("testReturnModelAndView")
    public ModelAndView returnModelAndView(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        mv.addObject("msg","借助ModelAndVeiw的addObject方法添加的数据");
        return mv;
    }
}
