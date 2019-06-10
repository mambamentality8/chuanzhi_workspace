package myjdbctemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 模拟jdbcTemplate的query方法
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public class JdbcTemplateTemp {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Object query(String sql, MyRowMapper rm, Object... args){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try{
            //1.获取连接
            conn = dataSource.getConnection();
            //2.获取预处理对象
            pstm = conn.prepareStatement(sql);
            System.out.println(sql);
            //3.获取参数的元信息
            ParameterMetaData pmd = pstm.getParameterMetaData();
            //4.获取参数的个数
            int parameterCount = pmd.getParameterCount();
            //5.如果参数个数和方法给定的可变参数个数不一致，则一定执行不了
            if(parameterCount > 0){
                System.out.println("有参数");
                if(args == null){
                    throw new NullPointerException("参数为空");
                }
                if(parameterCount != args.length){
                    throw new IllegalArgumentException("参数个数不对");
                }
                //遍历参数个数，给参数赋值
                for(int i=0;i<parameterCount;i++){
                    pstm.setObject(i+1,args[i]);
                }
            }
            //6.执行sql语句
            rs = pstm.executeQuery();

            return rm.mapRow(rs);//策略模式
        }catch(Exception e){
            throw  new RuntimeException(e);
        }finally {
            release(rs,pstm,conn);
        }
    }



















    private void release(ResultSet rs,PreparedStatement pstm,Connection conn){
        if(rs != null){
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(pstm != null){
            try{
                pstm.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(conn != null){
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
