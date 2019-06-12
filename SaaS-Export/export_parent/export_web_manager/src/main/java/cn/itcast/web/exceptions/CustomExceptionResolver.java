package cn.itcast.web.exceptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomExceptionResolver implements HandlerExceptionResolver{

    /**
     * 1.跳转到了美化了的错误页面
     * 2.携带错误信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv = new ModelAndView();
        //跳转的页面
        mv.setViewName("error");
        //舔砖页面需要携带的数据
        mv.addObject("errorMsg","对不起,我错了");
        mv.addObject("ex",ex);
        return mv;
    }
}
