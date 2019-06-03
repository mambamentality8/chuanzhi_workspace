package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个剧组
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class Client {

    public static void main(String[] args) {
        //早期：直接去家里找
        Actor actor = new Actor();

        //通过经纪公司来找演员

        /**
         * 动态代理
         *  作用：不修改源码的基础上，对已有方法增强
         *  特点：字节码是随用随创建，随用随加载。
         *  基于接口的动态代理：
         *  提供者：JDK官方
         *  要求：被代理对象最少实现一个接口。
         *  涉及的类：Proxy
         *  涉及的方法：newProxyInstance
         *  方法的参数：
         *      ClassLoader：类加载器。负责加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法。
         *      Class[]：字节码数组。代理对象具有的方法。和被代理对象实现相同的接口。
         *               如果被代理对象本身是一个接口的话，直接把被代理对象存入字节码数组中。
         *               xxx.getClass().getInterfaces() || new Class[]{xxx}
         *               固定写法。
         *      InvocationHandler：如何代理的接口。谁用谁写。用于增强方法的。需要我们自己提供一个该接口的实现类。
         *                         通常情况下可以写成匿名内部类。
         *                         策略模式：
         *                              数据已经有了
         *                              目的明确。
         *                              达成目标的过程即是策略。
         *
         */
        IActor proxyActor = (IActor)Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 此处提供增强的代码
                     * 执行被代理对象的任何方法，都会经过该方法。
                     * @param proxy     代理对象的引用
                     * @param method    当前执行的方法
                     * @param args      当前方法所需的参数
                     * @return          和被代理对象的方法具有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        //1.取出当前方法的参数
                        Float money= (Float) args[0];
                        //2.判断方法是什么
                        if("basicAct".equals(method.getName())){
                            //基本演出：抽取20% 要求一天5000块以上才接
                            if(money > 5000f){
                                rtValue = method.invoke(actor,money*0.8f);
                            }
                        }
                        if("dangerAct".equals(method.getName())){
                            //高危演出：抽取10% 要求一天20000块以上才接
                            if(money > 20000f){
                                rtValue = method.invoke(actor,money*0.9f);
                            }
                        }
                        return rtValue;
                    }
                });


        proxyActor.basicAct(10000f);
        proxyActor.dangerAct(50000f);
    }
}
