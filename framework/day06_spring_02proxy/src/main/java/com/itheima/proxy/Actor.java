package com.itheima.proxy;

/**
 * 一个演员
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Actor implements IActor {

    /**
     * 基本表演
     * @param money
     */
    public void basicAct(Float money){
        System.out.println("拿到钱，开始基本的表演："+money);
    }

    /**
     * 危险的表演
     * @param money
     */
    public void dangerAct(Float money){
        System.out.println("拿到钱，开始危险的表演："+money);
    }
}
