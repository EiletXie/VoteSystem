package com.suntak.demo.dao;

import com.suntak.demo.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 获取所有用户信息
     * @return userList
     */
    List<User> queryUser();

    /**
     * 获取单个用户信息
     * @param userid
     * @return user
     */
    User getUserById(int userid);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param userid
     * @return
     */
    int deletUser(int userid);
}
