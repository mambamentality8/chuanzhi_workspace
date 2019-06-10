package com.itheima.mapper;

import cn.itcast.domain.User;

import java.util.List;

public interface UserMapper {
    //保存
    void save(User user);
    //根据UID查询
    User findByUid(Integer i);
    // 根据UID更新
    void update(User user);
    // 根据ID删除
    void deleteByUid(Integer uid);

    List<User> findAll();
}
