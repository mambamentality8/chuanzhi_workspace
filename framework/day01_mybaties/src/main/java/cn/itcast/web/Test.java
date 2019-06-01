package cn.itcast.web;

import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("传智播客");
        user.setPassword("admin");
        user.setBirthday(new Date().toLocaleString());
        user.setEmail("admin@itcast.cn");
        user.setPhoneNumber("110");
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.save(user);
        sqlSession.commit();
        sqlSession.close();
    }
}


