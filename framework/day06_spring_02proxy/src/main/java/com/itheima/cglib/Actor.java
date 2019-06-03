package com.itheima.cglib;

/**
 * 一个演员
 */
public class Actor {

    /**
     * 基本表演
     * @param money
     */
    public void basicAct(Float money){
        System.out.println("拿到钱，开始基本的表演cglib："+money);
    }

    /**
     * 危险的表演
     * @param money
     */
    public void dangerAct(Float money){
        System.out.println("拿到钱，开始危险的表演cglib："+money);
    }
}
