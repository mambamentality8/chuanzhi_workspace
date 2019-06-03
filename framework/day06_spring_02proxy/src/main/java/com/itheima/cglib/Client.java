package com.itheima.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

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
         *  基于子类的动态代理：
         *  提供者：第三方cglib库
         *  要求：被代理对象不能是最终类。不能被final修饰
         *  涉及的类：Enhancer
         *  涉及的方法：create
         *  方法的参数：
         *      Class：字节码。被代理对象的字节码。固定写法。

         *      Callback：如何代理的接口。谁用谁写。用于增强方法的。需要我们自己提供一个该接口的实现类。
         *                         通常情况下可以写成匿名内部类。
         *                         我们需要使用它的子接口：MethodInterceptor
         *                         策略模式：
         *                              数据已经有了
         *                              目的明确。
         *                              达成目标的过程即是策略。
         *
         */
        Actor cglibActor = (Actor)Enhancer.create(actor.getClass(), new MethodInterceptor() {
            /**
             * 此处提供增强的代码
             * 执行被代理对象的任何方法，都会经过该方法。
             * @param proxy         代理对象的引用
             * @param method        当前执行的方法
             * @param args          当前方法所需的参数
             * @param methodProxy   当前方法的代理对象
             * @return              和被代理对象的方法具有相同的返回值
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object rtValue = null;
                //1.取出当前方法的参数
                Float money= (Float) args[0];
                //2.判断方法是什么
                if("basicAct".equals(method.getName())){
                    //基本演出：抽取20% 要求一天5000块以上才接
                    if(money > 5000f){
                        rtValue = method.invoke(actor,money*0.75f);
                    }
                }
                if("dangerAct".equals(method.getName())){
                    //高危演出：抽取10% 要求一天20000块以上才接
                    if(money > 20000f){
                        rtValue = method.invoke(actor,money*0.85f);
                    }
                }
                return rtValue;
            }
        });

















        cglibActor.basicAct(10000f);
        cglibActor.dangerAct(50000f);
    }
}
