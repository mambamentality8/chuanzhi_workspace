package cn.itcast.test;

import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import cn.itcast.util.BaseMapperUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CRUDTest extends BaseMapperUtil {
    //保存
    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setName("传智播客3");
        user.setPassword("admin");
        user.setBirthday(new Date().toLocaleString() );
        user.setEmail("admin@itcast.cn");
        user.setPhoneNumber("110");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.save(user);
    }

    //根据UID查询
    @Test
    public void testFindByUid() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findByUid(1);
        System.out.println(user);
    }

    //根据UID修改
    @Test
    public void testUpdate() {
        User user = new User();
        user.setUid(1);
        user.setPassword("adminadmin");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.update(user);
    }

    //根据ID删除
    @Test
    public void testDeleteByUid() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteByUid(2);
    }

    @Test
    public void testFindAll() {
        //1.创建dao接口的动态代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //3.调用dao方法保存
        List<User> list = userMapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
