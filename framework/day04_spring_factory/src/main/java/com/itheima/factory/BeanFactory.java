package com.itheima.factory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 用于创建Bean对象的
 * Bean指的是JavaBean
 * JavaBean，用Java语言开发的可重用组件。
 * 实体类，service, dao
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class BeanFactory {

    /**
     * 1.它只能用于读取，不能用于写入
     * 2.它只能读取properties文件，别的不行
     * 3.它只能读取类路径下的properties文件，别的地方的不行
     * 细节：
     *  在指定资源文件（properties文件）位置时，是使用包的写法来写的。
     *         com.itheima.config.bean          正确的
     *   而不是路径的方式
     *          com/itheima/config/bean         错误的
     */
    private static ResourceBundle bundle;
    //用于存放对象的容器
    private static Map<String,Object> beans;//就是那个IOC容器


    static {
        try{
            //实例化bundle对象
            bundle = ResourceBundle.getBundle("bean");
            //实例化beans
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的key
            Enumeration<String> keys = bundle.getKeys();
            //遍历所有的key
            while(keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement();
                //使用bundle对象的getString方法取出来的是全限定类名字符串
                String classPath = bundle.getString(key);
                //反射创建对象
                Object value = Class.forName(classPath).newInstance();
                //存入map中
                beans.put(key,value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化容器失败，程序终止执行！");
        }
    }

    /**
     * 从map中，根据key获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
       return beans.get(beanName);
    }


    /*public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = bundle.getString(beanName);
            bean = Class.forName(beanPath).newInstance();
            return bean;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }*/



















    /*private static Properties props ;

    static{
        InputStream in = null;
        try {
            in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props = new Properties();
            props.load(in);

        }catch (Exception e){
            //一会要处理
        }finally {
            if(in != null){
                try {
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }*/
}
