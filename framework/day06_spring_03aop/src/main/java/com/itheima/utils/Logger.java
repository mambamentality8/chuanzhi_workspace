package com.itheima.utils;

/**
 * 模拟一个记录日志的增强类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Logger {

    /**
     * 计划让其在切入点方法执行之前执行。
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法开始记录日志了");
    }
}
