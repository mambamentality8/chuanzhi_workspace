package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** json格式数据交互
 *
 *  @RequestBody:
 *        作用：获取请求正文的全部内容。包括key和value
 *  @ResponseBody:
 *        作用：是把返回值由一个对象，转成JSON
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Controller
@RequestMapping("springmvc")
public class JsonDataController {

    /**
     * 请求参数默认情况下，体现形式是：
     *      key=value&key=value
     * @param user
     * @return
     */
    @RequestMapping("testJson")

    public @ResponseBody User testJson(@RequestBody User user){
        System.out.println("请求过来的json"+user);//{"username":"张三","age":18,"gender":"男"}
        //修改年龄为30
        user.setAge(30);
        return user;//此时年龄已经是改过的了
    }
}
