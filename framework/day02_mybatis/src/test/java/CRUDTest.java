import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import cn.itcast.util.BaseMapperUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CRUDTest extends BaseMapperUtil {

    @Test
    public void findByCondition() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findByCondition("传智播客","admin@otcast.cn");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void update2() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.update("1","","");
    }


    @Test
    public void insert() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insert("传智播客2","admin1@itcast.cn","120","2019-05-27","adminadmin1");
    }


    @Test
    public void find4() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> uids = new ArrayList<>();
        uids.add(1);
        uids.add(3);
        List<User> userMapper4 = userMapper.find4(uids);
        for (User user : userMapper4) {
            System.out.println(user);
        }
    }
}
