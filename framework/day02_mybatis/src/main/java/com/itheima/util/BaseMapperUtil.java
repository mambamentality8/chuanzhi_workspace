package com.itheima.util;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

public class BaseMapperUtil {
    protected SqlSession sqlSession = null;

    @Before
    public void init()

    {
        sqlSession = MybatisUtil.openSession();
    }

    @After
    public void destory()

    {
        sqlSession.commit();
        sqlSession.close();
    }
}
