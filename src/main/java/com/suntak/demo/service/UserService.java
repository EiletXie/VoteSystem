package com.suntak.demo.service;

import com.suntak.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户信息
     * @return userList
     */
    List<User> getUserList();

    /**
     * 获取单个用户信息
     * @param userid
     * @return user
     */
    User getUserById(int userid);

    /**
     * 检查用户登录信息
     * @param username
     * @param password
     * @return
     */
    User checkUser(String username,String password);

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    boolean modifyUser(User user);

    /**
     * 删除用户
     * @param userid
     * @return
     */
    boolean deleteUser(int userid);
}
