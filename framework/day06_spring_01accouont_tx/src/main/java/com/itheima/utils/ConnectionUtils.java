package com.itheima.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，用于把连接和ThreadLocal绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取连接：
     *     每次都必须是当前线程的连接
     * @return
     */
    public Connection getConnection(){
        try{
            //1.获取当前线程上的连接
            Connection conn = tl.get();
            //2.判断当前线程上是否有连接
            if(conn == null){
                //当前线程上没有，就需要给他绑定一个
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            //3.返回当前线程上的
            return tl.get();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把线程和连接解绑
     */
    public void remove(){
        tl.remove();
    }
}
