package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ModelAttribute注解的使用
 *   作用：
 *      写在方法上，表示当前方法一定会在控制器方法执行之前执行。
 *      写在参数前面，表示从Map中获取指定数据，给参数赋值。
 *   属性：
 *      value：用于指定map中的key
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Controller
@RequestMapping("springmvc")
public class ModelAttributeController {

    /*@ModelAttribute
    public void showModel(){
        System.out.println("showModel方法执行了");
    }*/

    /**
     * 控制器方法
     * @return
     */
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(){
        System.out.println("控制器的方法执行了");
        return "success";
    }
//-----------------------------------------------------------------------------
    /**
     * 数据库中原本用户的信息是：
     *   User{
     *       id:1
     *       username:泰斯特
     *       age：18
     *       gender：男
     *       password:1234
     *   }
     * 改后的数据应该是：
     *   User{
     *       id:1
     *       username:test
     *       age：21
     *       gender：女
     *       password:1234
     *   }
     * 修改用户的功能
     */
    @RequestMapping("updateUser")
    public String updateUser(@ModelAttribute("dbuser") User user){
        System.out.println("修改后的用户信息是："+user);
        return "success";
    }

    /**
     * 我希望它在控制器方法执行之前，先去调用业务层根据id查询一下用户信息
     * @param id
     */
    @ModelAttribute
    public void showModel(Integer id,Model model){
        User user = this.findById(id);
       model.addAttribute("dbuser",user);
    }
//    @ModelAttribute
//    public void showModel(Integer id,Map<String,User> map){
//        User user = this.findById(id);
//        map.put("user",user);
//    }
//    @ModelAttribute
//    public void showModel(Integer id,ModelMap map){
//        User user = this.findById(id);
//        map.put("user",user);
//    }

















    /**
     * 模拟业务层service的根据id查询
     * @param id
     * @return
     */
    private User findById(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("泰斯特");
        user.setAge(18);
        user.setGender("男");
        user.setPassword("1234");
        return user;
    }
}
