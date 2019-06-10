package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 事务管理的工具类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Component
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        try{
            //1.开启事务
            this.beginTransaction();
            //2.获取参数
            Object[] args = pjp.getArgs();
            //3.执行方法
            Object rtValue = pjp.proceed(args);
            //4.提交事务
            this.commit();

            return  rtValue;
        }catch (Throwable e){
            //5.回滚事务
            this.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            this.close();
        }
    }


    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtils.getConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    public void close(){
        try {
            connectionUtils.getConnection().close();
            //解绑
            connectionUtils.remove();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
