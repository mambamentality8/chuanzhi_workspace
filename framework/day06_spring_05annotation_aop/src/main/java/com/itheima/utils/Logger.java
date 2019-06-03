package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 模拟一个记录日志的增强类
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
@Component
@Aspect//表示当前类是一个切面类
public class Logger {

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 前置通知
     */
    //@Before("pt1()")
    public void beforePrintLog(){
        System.out.println("Logger类中的beforePrintLog方法开始记录日志了");
    }

    /**
     * 后置通知
     */
   // @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("Logger类中的afterReturningPrintLog方法开始记录日志了");
    }

    /**
     * 异常通知
     */
   // @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("Logger类中的afterThrowingPrintLog方法开始记录日志了");
    }
    /**
     * 最终通知
     */
   // @After("pt1()")
    public void afterPrintLog(){
        System.out.println("Logger类中的afterPrintLog方法开始记录日志了");
    }

    /**
     * 配置环绕通知
     * 问题：
     *     当我们配置了环绕通知之后，当运行时，切入点方法没有执行，而环绕通知执行了。
     * 分析：
     *      我们的环绕通知中，没有明确的切入点方法调用。
     *  解决：
     *      Spring框架给我们提供了一个接口：ProceedingJoinPoint。该接口可以作为环绕通知的方法参数来用。
     *      在程序运行期，spring会给我们提供该接口的实现类，我们在环绕通知中直接使用即可。
     *      接口中有个方法：
     *              proceed()，它的作用就相当于method.invoke()。明确调用切入点方法
     *
     *   spring中的环绕通知：
     *      它是spring为我们提供的一种可以在代码中手动控制增强方法何时执行的机制。
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            System.out.println("环绕通知执行了。。。前置");
            //获取参数
            Object[] args = pjp.getArgs();
            //执行方法
            rtValue = pjp.proceed(args);//明确的切入点方法调用
            System.out.println("环绕通知执行了。。。后置");
            return rtValue;

        }catch (Throwable e){
            System.out.println("环绕通知执行了。。。异常");
            throw new RuntimeException(e);
        }finally {
            System.out.println("环绕通知执行了。。。最终");
        }



    }

}
