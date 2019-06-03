package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 一个用于创建service代理对象的工厂：
 *      此时我们只用它创建AccountServiceImpl的代理对象
 * 我们在此处主要是突出AOP
 */
public class BeanFactory {
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    //原始对象
    private IAccountService accountService;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 创建代理对象，并加入事务的支持
     * @return
     */
    public IAccountService getProxyAccountService(){
        IAccountService proxyAccountService = (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 此处增强方法，添加事务
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if("generateCode".equals(method.getName())){
                            return method.invoke(accountService,args);
                        }
                        Object rtValue = null;
                        try{
                            //开启事务
                            transactionManager.beginTransaction();

                            //执行业务层的方法
                            rtValue = method.invoke(accountService, args);

                            //提交事务
                            transactionManager.commit();
                            return rtValue;
                        }catch (Exception e){
                            //回滚事务
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            //释放资源
                            transactionManager.close();
                        }
                    }
                });
        return proxyAccountService;
    }
}
