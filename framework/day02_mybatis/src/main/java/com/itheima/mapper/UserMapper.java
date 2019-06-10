package com.itheima.mapper;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> findByCondition(@Param("name")String name, @Param("email")String email);

    void update (@Param("uid")String uid,@Param("name")String name, @Param("email")String email);

    void update2 (@Param("uid")String uid,@Param("name")String name, @Param("email")String email);

    void insert(@Param("name")String name,@Param("email")String email,@Param("phoneNumber")String phoneNumber,@Param("birthday")String birthday,@Param("password")String password);

    List<User> find4(List<Integer> uids);
}
